package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Scanner;


public class ExcelProcessing
{
    public int getCountOfCells(Sheet sheet)
    {
        int counter =0;
        Row row = sheet.getRow(0);
        for(Cell cell :row)
        {
            counter++;
        }
        return counter;
    }

    public int[] getColumnWidth(int[] width, Sheet sheet)
    {
        for(Row row : sheet)
        {
            for(int i=0;i<width.length;i++)
            {
                Cell cell = row.getCell(i);
                switch (cell.getCellType())
                {
                    case NUMERIC :
                        int length = String.valueOf(cell.getNumericCellValue()).length();
                        width[i] = Math.max(width[i],length);
                        break;
                    case STRING:
                        int length1 = cell.getStringCellValue().length();
                        width[i] = Math.max(width[i],length1);
                        break;
                }
            }
        }
        return width;
    }

    public void printData(Sheet sheet,int [] width)
    {
        for(Row row : sheet)
        {
            for(int i=0;i<width.length;i++)
            {
                Cell cell = row.getCell(i);
                switch (cell.getCellType())
                {
                    case NUMERIC :
                        System.out.printf("%-"+width[i]+"s ",cell.getNumericCellValue());
                        break;
                    case STRING:
                        System.out.printf("%-"+width[i]+"s ",cell.getStringCellValue());
                        break;
                }
            }
            System.out.println();
        }
    }

    public void dataTypeofRow (Sheet sheet,String[] dataType)
    {
        Row row = sheet.getRow(1);
        for(Cell cell :row)
        {
            dataType[cell.getColumnIndex()] = String.valueOf(cell.getCellType());
        }
    }

    public void setNewRow (Row row,String [] dataType)
    {
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<dataType.length;i++) {
            switch (dataType[i]) {
                case "STRING":
                    System.out.println("Enter the data in the String format ");
                    String cellValue = sc.nextLine();
                    row.getCell(i).setCellValue(cellValue);
                    break;
                case "NUMERIC":
                    System.out.println("Enter the data in the Double format");
                    double cellValue1 = sc.nextDouble();
                    row.getCell(i).setCellValue(cellValue1);
                    sc.nextLine();
                    break;
            }
        }
    }

    public void deleteRow(Sheet sheet,int rowNo)
    {
        Row row = sheet.getRow(rowNo);
        sheet.removeRow(row);
        System.out.println("removed row");
    }

}
