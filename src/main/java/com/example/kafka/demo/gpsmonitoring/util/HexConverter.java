package com.example.kafka.demo.gpsmonitoring.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HexConverter {
        public static String byteArrayToString(byte[] byteArray) {
            StringBuilder result = new StringBuilder();
            for (byte b : byteArray) {
                result.append(String.format("%02X ", b));
            }
            return result.toString().trim();
        }
}
