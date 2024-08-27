package com.example.pagination.controller;

import com.example.pagination.repository.DataRepository;
import com.example.pagination.service.DataService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Controller
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/download")
    public ResponseEntity<?> downloadToExcel(@RequestParam int Page) throws IOException, InterruptedException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("DATA");

        ExecutorService executor = Executors.newFixedThreadPool(Page);

        for (int i = 0; i < Page; i++) {
            DataService service = new DataService(i, sheet, dataRepository);
            executor.submit(service);
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);  // Wait for all threads to finish

        try (FileOutputStream fileOut = new FileOutputStream("Data.xlsx")) {
            workbook.write(fileOut);
        }

        File file = new File("Data.xlsx");
        InputStreamResource in = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(file.length())
                .body(in);
    }
}
