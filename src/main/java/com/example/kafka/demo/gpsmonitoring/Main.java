package com.example.kafka.demo.gpsmonitoring;

import com.example.kafka.demo.gpsmonitoring.Excel.CreateFile;
import com.example.kafka.demo.gpsmonitoring.Excel.WriterXlsx;
import com.example.kafka.demo.gpsmonitoring.model.GPSData;
import com.example.kafka.demo.gpsmonitoring.service.GPSDataBilder;
import com.example.kafka.demo.gpsmonitoring.websocket.DataReceiver;
import java.io.IOException;

import static com.example.kafka.demo.gpsmonitoring.util.HexConverter.byteArrayToString;

public class Main {
    public static void main(String[] args) throws IOException {
        DataReceiver dataReceiver = new DataReceiver("localhost",8080);
        GPSData gpsData  =new GPSDataBilder().createGPSDataFromInput(byteArrayToString(dataReceiver.receiveData()));
        CreateFile createFile = new CreateFile();
        createFile.create();
        WriterXlsx writerXlsx = new WriterXlsx();
        writerXlsx.writeInExel(gpsData);

    }
}
