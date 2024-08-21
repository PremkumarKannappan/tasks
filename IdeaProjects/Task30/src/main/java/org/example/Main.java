package org.example;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filepath ; int counter;
        Scanner sc = new Scanner(System.in);

        ExcelProcessing excel = new ExcelProcessing();
        try {
            System.out.println("Enter the file name of the excel file:");
            String fileName = sc.nextLine();
            try (FileInputStream file = new FileInputStream(fileName)) {

                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheetAt(0);

                counter = excel.getCountOfCells(sheet);
                int [] width = new int[counter];
                for (int k=0; k<counter; k++)
                    width[k] =0;
                width = excel.getColumnWidth(width,sheet);
                String[] dataType = new String[counter];
                excel.printData(sheet,width);
                excel.dataTypeofRow(sheet,dataType);
                System.out.println(Arrays.toString(dataType));
                int lastRow = sheet.getLastRowNum();
                sheet.createRow(++lastRow);
                for(int i=0;i<counter;i++)
                {
                    sheet.getRow(lastRow).createCell(i, CellType.valueOf(dataType[i]));
                }
                excel.setNewRow(sheet.getRow(lastRow),dataType );
                try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
                    workbook.write(fileOut);
                }
                excel.printData(sheet,width);
                System.out.println("Enter the Register number for deleting the record: ");
                String RegNo = sc.nextLine();int rowNo = 0;
                for(Row row: sheet)
                {
                   if(row.getCell(0).getStringCellValue().equals(RegNo))
                   {
                       rowNo = row.getRowNum();
                       break;
                   }
                }
                if(rowNo!=0)
                    excel.deleteRow(sheet,rowNo);
                else
                    System.out.println("no data found");
                int n= sheet.getLastRowNum()-rowNo;
                sheet.shiftRows(rowNo+1,sheet.getLastRowNum(),-1);
                excel.printData(sheet,width);

                try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
                    workbook.write(fileOutputStream);
                }

            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}