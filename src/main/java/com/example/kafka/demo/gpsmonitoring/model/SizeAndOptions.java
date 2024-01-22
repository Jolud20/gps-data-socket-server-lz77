package com.example.kafka.demo.gpsmonitoring.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SizeAndOptions {
    private Integer payload;
    private Boolean ID;
    private Boolean typeIndex;
    private Boolean acknowledge;
    private Boolean payloadLZ;
    private Boolean payloadToBeDefined;

    public SizeAndOptions(Builder builder) {
        this.payload = builder.payload;
        this.ID = builder.ID;
        this.typeIndex = builder.typeIndex;
        this.acknowledge = builder.acknowledge;
        this.payloadLZ = builder.payloadLZ;
        this.payloadToBeDefined = builder.payloadToBeDefined;
    }

    public static class Builder {
        private Integer payload;
        private Boolean ID;
        private Boolean typeIndex;
        private Boolean acknowledge;
        private Boolean payloadLZ;
        private Boolean payloadToBeDefined;

        public Builder setPayload(Integer payload) {
            this.payload = payload;
            return this;
        }

        public Builder setID(char ID) {
            this.ID = ID =='1';
            return this;
        }

        public Builder setTypeIndex(char typeIndex) {
            this.typeIndex = typeIndex== '1';
            return this;
        }

        public Builder setAcknowledge(char acknowledge) {
            this.acknowledge = acknowledge == '1';
            return this;
        }

        public Builder setPayloadLZ(char bytePayloadLZ) {
            this.payloadLZ = bytePayloadLZ == '1';
            return this;
        }

        public Builder setPayloadToBeDefined(char value) {
            this.payloadToBeDefined = value == '1';
            return this;
        }

        public SizeAndOptions build() {
            return new SizeAndOptions(this);
        }
    }
}
