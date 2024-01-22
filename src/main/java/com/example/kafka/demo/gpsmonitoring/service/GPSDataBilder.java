package com.example.kafka.demo.gpsmonitoring.service;

import com.example.kafka.demo.gpsmonitoring.model.GPSData;
import com.example.kafka.demo.gpsmonitoring.service.SizeAndOptionsBuilder;
import com.example.kafka.demo.gpsmonitoring.util.TypeAndIndexBuilder;

public class GPSDataBilder {
    GPSData newPackage;
    public GPSData createGPSDataFromInput(String inputPackage){
        String[] input=inputPackage.split("(?<=\\G.{" + 2 + "})");
        newPackage=new GPSData.Builder().
                setSignature(Byte.valueOf(input[0]))
                .setSizeAndOptions(new SizeAndOptionsBuilder()
                        .createSizeAndOptionsBuilder(input[2]+input[1]))
                .setID(Long.valueOf((input[6] + input[5] + input[4] + input[3]),16))
                .setTypeAndIndex(new TypeAndIndexBuilder().createEntity(input[8]+input[7]))
                .setSize(input.length-10)
                .build();
        return newPackage;
    }
}
