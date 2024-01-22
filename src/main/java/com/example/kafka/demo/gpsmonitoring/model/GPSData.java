package com.example.kafka.demo.gpsmonitoring.model;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class GPSData {
    private Integer size;
    private Byte signature;
    private SizeAndOptions sizeAndOptions;
    private TypeAndIndex typeIndex;
    private Long ID;
    private Integer acknowledge;
    private Integer payload;
    private Integer packageSize;
    private Integer CRC;

    public GPSData(Builder builder) {
        this.size=builder.size;
        this.signature = builder.signature;
        this.sizeAndOptions = builder.sizeAndOptions;
        this.typeIndex = builder.typeIndex;
        this.ID = builder.ID;
        this.acknowledge = builder.acknowledge;
        this.payload = builder.payload;
        this.packageSize = builder.packageSize;
        this.CRC = builder.CRC;
    }

    public static class Builder {
        private Byte signature;
        private SizeAndOptions sizeAndOptions;
        private TypeAndIndex typeIndex;
        private Long ID;
        private Integer acknowledge;
        private Integer payload;
        private Integer packageSize;
        private Integer CRC;
        private Integer size;

        public Builder setSignature(Byte signature) {
            this.signature = signature;
            return this;
        }

        public Builder setSizeAndOptions(SizeAndOptions sizeAndOptions) {
            this.sizeAndOptions = sizeAndOptions;
            return this;
        }

        public Builder setID(Long ID) {
            this.ID = ID;
            return this;
        }
        public Builder setTypeAndIndex(TypeAndIndex typeIndex){
            this.typeIndex=typeIndex;
            return this;
        }

        public Builder setAcknowledge(Integer acknowledge) {
            this.acknowledge = acknowledge;
            return this;
        }

        public Builder setPayload(Integer payload) {
            this.payload = payload;
            return this;
        }

        public Builder setPackageSize(Integer packageSize) {
            this.packageSize = packageSize;
            return this;
        }

        public Builder setCRC(Integer CRC) {
            this.CRC = CRC;
            return this;
        }
        public Builder setSize(Integer size){
            this.size=size;
            return this;
        }

        public GPSData build() {
            return new GPSData(this);
        }
    }
}
