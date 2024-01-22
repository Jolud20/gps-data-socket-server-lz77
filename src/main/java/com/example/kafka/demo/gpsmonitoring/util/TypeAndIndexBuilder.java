package com.example.kafka.demo.gpsmonitoring.util;

import com.example.kafka.demo.gpsmonitoring.model.TypeAndIndex;
public class TypeAndIndexBuilder {
    public TypeAndIndex typeAndIndex;
    public TypeAndIndex createEntity(String input){
        typeAndIndex= new TypeAndIndex.Builder()
                .setIndexPackage(Integer.parseInt(input.substring(0,2)))
                .setTypePackage(Integer.parseInt(input.substring(3,4)))
                .build();
        return typeAndIndex;
    }
}
