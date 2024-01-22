package com.example.kafka.demo.gpsmonitoring.Excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class CreateFile {
    public void create() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Отчёт");
        sheet.setColumnWidth(0,1000);
        sheet.setColumnWidth(1,1000);
        sheet.setColumnWidth(2,1000);
        sheet.setColumnWidth(3,5000);
        sheet.setColumnWidth(4,15000);
        sheet.setColumnWidth(5,5000);
        sheet.setColumnWidth(6,5000);
        sheet.setColumnWidth(7,5000);

        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Signature");
        row.createCell(1).setCellValue("Size");
        row.createCell(2).setCellValue("Size/Options");
        row.createCell(3).setCellValue("ID");
        row.createCell(4).setCellValue("Type/Index");
        row.createCell(5).setCellValue("Acknowledge");
        row.createCell(6).setCellValue("PayLoad");
        row.createCell(7).setCellValue("CRC");


        File file = new File("Отчёты//Отчёт.xlsx");
        try(FileOutputStream out=new FileOutputStream(file)){
            workbook.write(out);
        }
        workbook.close();
    }
}
