package com.example.pagination.service;

import com.example.pagination.entity.Data;
import com.example.pagination.repository.DataRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public class DataService implements Runnable {

    private final Integer pageNumber;
    private final Sheet sheet;
    private final DataRepository dataRepository;

    public DataService(Integer pageNumber, Sheet sheet, DataRepository dataRepository) {
        this.pageNumber = pageNumber;
        this.sheet = sheet;
        this.dataRepository = dataRepository;
    }


    @Override
    public void run() {
        Pageable pageable = PageRequest.of(pageNumber, 20);
        Page<Data> pagedData = dataRepository.findAll(pageable);

        synchronized (sheet) {
            int startRow = pageNumber * 20;
            for (Data data : pagedData) {
                Row row = sheet.createRow(startRow++);
                row.createCell(0).setCellValue(data.getId());
                row.createCell(1).setCellValue(data.getName());
            }
        }
    }
}
