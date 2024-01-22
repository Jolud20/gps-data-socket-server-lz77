package com.example.kafka.demo.gpsmonitoring.Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class CheckRdyExistDay {
    public boolean rdyExist(String name) throws IOException {
        File file = new File("Отчёты//Oтчёт.xlsx");
        FileInputStream in=new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row cells : sheet) {
            Iterator<Cell> cellIterator = cells.cellIterator();
            int count = 0;
            if(cellIterator.next().getStringCellValue().equals(name)){
                return false;
            }
        }
        in.close();
        workbook.close();
        return true;
    }
}
