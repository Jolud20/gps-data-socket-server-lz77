package com.example.kafka.demo.gpsmonitoring.Excel;

import com.example.kafka.demo.gpsmonitoring.model.GPSData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class WriterXlsx {
    Row row1;
    public void writeInExel(GPSData gpsData) throws IOException {
        File file = new File("Отчёты//Отчёт.xlsx");
        FileInputStream in=new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int lastRow = sheet.getLastRowNum()+1;
            row1 =sheet.createRow(lastRow);
            for(int i = 0;i<13;i++){
                switch (i) {
                    case 0 -> row1.createCell(i).setCellValue(gpsData.getSignature());
                    case 1 -> row1.createCell(i).setCellValue(gpsData.getSizeAndOptions().toString());
                    case 2 -> row1.createCell(i).setCellValue(gpsData.getID());
                    case 3 -> row1.createCell(i).setCellValue(gpsData.getTypeIndex().toString());
//                    case 4 -> row1.createCell(i).setCellValue(gpsData.getAcknowledge());
//                    case 5 -> row1.createCell(i).setCellValue(gpsData.getPayload());
//                    case 6 -> row1.createCell(i).setCellValue(gpsData.getCRC());
                }
            }
                try(FileOutputStream out=new FileOutputStream(file)){
                    workbook.write(out);
                }catch (IOException e){
                    e.printStackTrace();
                }
    }
}
