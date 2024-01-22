package com.example.kafka.demo.gpsmonitoring.service;

import com.example.kafka.demo.gpsmonitoring.model.SizeAndOptions;
import lombok.Data;

@Data
public class SizeAndOptionsBuilder {
    public SizeAndOptions sizeAndOptions;
    public SizeAndOptions createSizeAndOptionsBuilder(String input){
         input = Integer.toBinaryString(Integer.parseInt(input,16));
        int ln= input.length()-1;
        sizeAndOptions = new SizeAndOptions.Builder()
                .setPayloadToBeDefined(input.charAt(ln--))
                .setPayloadLZ(input.charAt(ln--))
                .setAcknowledge(input.charAt(ln--))
                .setTypeIndex(input.charAt(ln--))
                .setID(input.charAt(ln--))
                .setPayload(Integer.parseInt(input.substring(0,ln),2))
                .build();

        return sizeAndOptions;
    }
}
