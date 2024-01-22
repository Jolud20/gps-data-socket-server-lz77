package com.example.kafka.demo.gpsmonitoring.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TypeAndIndex {
    private Integer typePackage;
    private Integer indexPackage;

    public TypeAndIndex(Builder builder){
        this.typePackage=builder.typePackage;
        this.indexPackage=builder.indexPackage;
    }
    public static class Builder {
        private Integer typePackage;
        private Integer indexPackage;

        public Builder setTypePackage(Integer typePackage){
            this.typePackage=typePackage;
            return this;
        }
        public Builder setIndexPackage(Integer indexPackage){
            this.indexPackage=indexPackage;
            return this;
        }
        public TypeAndIndex build(){
            return new TypeAndIndex(this);
        }
    }
}
