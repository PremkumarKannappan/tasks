package com.example.demo.service;

import com.example.demo.entity.StudentDetails;
import com.example.demo.repository.StudentDetailsRepository;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.kernel.pdf.PdfDocument;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentDetailsService {
    @Autowired
    StudentDetailsRepository studentDetailsRepository;

    public Optional<StudentDetails> findOne(long id) {
        return studentDetailsRepository.findById(id);
    }

    public StudentDetails
    addStudent(StudentDetails studentDetails) {

        return studentDetailsRepository.save(studentDetails);

    }

    public List<StudentDetails> findAll() {
        return new ArrayList<>(studentDetailsRepository.findAll());
    }

    public StudentDetails getByName(String name) {
        return studentDetailsRepository.getByName(name);
    }

    public String deleteById(Long id) {
        studentDetailsRepository.deleteById(id);
        return "Student details of the id " + id + " is deleted successfully";
    }

    public StudentDetails updateById(Long id, StudentDetails student) {

        return studentDetailsRepository.findById(id).map(newStudent ->
        {
            newStudent.setStudentName(student.getStudentName());
            return studentDetailsRepository.save(newStudent);
        }).orElseGet(() ->
        {
            student.setId(id);
            return studentDetailsRepository.save(student);
        });

    }

//    public ByteArrayInputStream exportToExcel() throws IOException
//    {
//        List<StudentDetails> students = studentDetailsRepository.findAll();
//        SimpleDateFormat date = new SimpleDateFormat("ddMMyyyy_hhmmss");
//        String timeStamp = date.format(new Date());
//        String sheetName = "STUDENT_DETAILS_" + timeStamp;
//        String[] columns = {"ID", "STUDENT_NAME"};
//
//        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
//
//            // Create a sheet in the workbook
//            Sheet sheet = workbook.createSheet(sheetName);
//
//            // Create the header row
//            Row headerRow = sheet.createRow(0);
//            for (int col = 0; col < columns.length; col++) {
//                Cell cell = headerRow.createCell(col);
//                cell.setCellValue(columns[col]);
//            }
//
//            // Populate data rows
//            int rowIndex = 1;
//            for (StudentDetails stud : students) {
//                Row dataRow = sheet.createRow(rowIndex++);
//                dataRow.createCell(0).setCellValue(stud.getId());
//                dataRow.createCell(1).setCellValue(stud.getStudentName());
//            }
//
//            // Write workbook content to the output stream
//            workbook.write(out);
//
//            // Close the workbook (important for proper file closure)
//            workbook.close();
//
//            // Return a ByteArrayInputStream from the output stream
//            return new ByteArrayInputStream(out.toByteArray());
//        }
//    }

    public ByteArrayInputStream exportToPDF() throws IOException {
        List<StudentDetails> students = studentDetailsRepository.findAll();
        SimpleDateFormat date = new SimpleDateFormat("ddMMyyyy_hhmmss");
        String timeStamp = date.format(new Date());
        String title = "Student Details Report _ " + timeStamp;

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // Initialize PDF document
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Set up font
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        document.add(new Paragraph(title).setFont(font).setFontSize(18));

        // Set up table and headers
        float[] columnWidths = {1, 4}; // Column widths
        Table table = new Table(columnWidths);

        // Add table header
        table.addHeaderCell(new Cell().add(new Paragraph("ID")));
        table.addHeaderCell(new Cell().add(new Paragraph("STUDENT NAME")));

        // Add rows to table
        for (StudentDetails stud : students) {
            table.addCell(new Cell().add(new Paragraph(String.valueOf(stud.getId()))));
            table.addCell(new Cell().add(new Paragraph(stud.getStudentName())));

            document.add(new Paragraph(String.valueOf(stud.getId())));
            document.add(new Paragraph(String.valueOf(stud.getStudentName())));
        }

        // Add table to document
        document.add(table);

        // Close document
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

}
