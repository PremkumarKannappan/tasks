package com.example.demo.controller;

import com.example.demo.entity.StudentDetails;
import com.example.demo.service.StudentDetailsService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentDetailsController
{
    @Autowired
    StudentDetailsService studentDetailsService;

    @GetMapping("/getAll")
    public ResponseEntity<?> findAll()
    {
        List<StudentDetails> newList =  studentDetailsService.findAll();
        System.out.println(newList);
        return new ResponseEntity<>(newList,HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<?> findById(@PathParam("id") long id)
    {
        return new ResponseEntity<>( studentDetailsService.findOne(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addStudent(@RequestBody StudentDetails studentDetails)
    {
        return new ResponseEntity<>(studentDetailsService.addStudent(studentDetails),HttpStatus.OK);
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String name){
        return new ResponseEntity<>(studentDetailsService.getByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam Long id)
    {
        return new ResponseEntity<>(studentDetailsService.deleteById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id,@RequestBody StudentDetails student)
    {
        return new ResponseEntity<>(studentDetailsService.updateById(id,student),HttpStatus.OK);
    }

//    @GetMapping("/toExcel")
//    public ResponseEntity<InputStreamResource> exportToExcel() throws IOException {
//        ByteArrayInputStream in = studentDetailsService.exportToExcel();
//        SimpleDateFormat date = new SimpleDateFormat("ddMMyyyy_hhmmss");
//        String timeStamp = date.format(new Date());
//        String fileName = "STUDENT_DETAILS_" + timeStamp + ".xlsx";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
//        headers.add(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(new InputStreamResource(in));
//    }

    @GetMapping("/toPDF")
    public ResponseEntity<InputStreamResource> exportToPDF() throws IOException {
        ByteArrayInputStream in = studentDetailsService.exportToPDF();
        SimpleDateFormat date = new SimpleDateFormat("ddMMyyyy_hhmmss");
        String timeStamp = date.format(new Date());
        String fileName = "STUDENT_DETAILS_" + timeStamp + ".pdf";  // Set the file name with .pdf extension

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(in));
    }

}
