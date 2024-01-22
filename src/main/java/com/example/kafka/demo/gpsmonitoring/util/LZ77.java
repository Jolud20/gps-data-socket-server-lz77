package com.example.kafka.demo.gpsmonitoring.util;

import java.util.ArrayList;
import java.util.List;

public class LZ77 {
    public static List<Triple> compress(String input) {
        List<Triple> compressedData = new ArrayList<>();
        int pos = 0;

        while (pos < input.length()) {
            int matchLength = 0;
            int bestMatchOffset = 0;

            for (int offset = 1; offset <= Math.min(pos, 255); offset++) {
                int startPos = Math.max(0, pos - offset);
                String substr = input.substring(pos, Math.min(pos + offset, input.length()));

                if (input.substring(startPos, pos).equals(substr) && substr.length() > matchLength) {
                    matchLength = substr.length();
                    bestMatchOffset = offset;
                }
            }

            if (matchLength > 0) {
                compressedData.add(new Triple(bestMatchOffset, matchLength, input.charAt(pos + matchLength)));
                pos += matchLength + 1;
            } else {
                compressedData.add(new Triple(0, 0, input.charAt(pos)));
                pos++;
            }
        }

        return compressedData;
    }

    public static String decompress(List<Triple> compressedData) {
        StringBuilder decompressedData = new StringBuilder();

        for (Triple triple : compressedData) {
            int offset = triple.getOffset();
            int length = triple.getLength();
            char nextChar = triple.getNextChar();

            if (offset == 0) {
                decompressedData.append(nextChar);
            } else {
                int startPos = decompressedData.length() - offset;
                for (int i = 0; i < length; i++) {
                    decompressedData.append(decompressedData.charAt(startPos + i));
                }
                decompressedData.append(nextChar);
            }
        }

        return decompressedData.toString();
    }

//    public static void main(String[] args) {
//        StringBuilder bl = new StringBuilder();
//        String originalData = "539e598f8a020003020700e378351ac39f040c04ffa92e806a28a13b1f00b638030c000067052c06ffffffff033006808001180003200100000700e478351ac40204303dab2e80cb27a13b1c00ac40021b30e778351ac502043082a72e8054020530bf30021b30e978351ac69f0d0c0433a72e80c123a13b2000df3807002579351ac79f06020a170000df28021b476179351ac8020f30021c81279d79351ac9020f30021c8207d979351aca020f30021c8157157a351acb022b8140517a351acc022b608d7a351acd022b60c97a351ace022b30057b351acf022b30417b351ad0022b307d7b351ad1020f3048021b30b97b351ad2020f3070030c004066021630f57b351ad30213841080021730317c351ad4021330c00217306d7c351ad5020f3050021b30a97c351ad602138170021830e57c351ad7020f3058021b30217d351ad8021385500218305d7d351ad9022b8110997d351ada022b8170d57d351adb022b30117e351adc020f3068030ce184680216304d7e351add020f3060030ce34469021630897e351ade021260e4021830c57e351adf021230e5021830017f351ae002293022f2";
//        List<Triple> compressedData = compress(originalData);
//        for(Triple i : compressedData){
//            bl.append(i.toString());
//        }
//        System.out.println("Compressed: " + bl);
//
//        String decompressedData = decompress(compressedData);
//        System.out.println("Decompressed: " + decompressedData);
//    }

    static class Triple {
        private final int offset;
        private final int length;
        private final char nextChar;

        public Triple(int offset, int length, char nextChar) {
            this.offset = offset;
            this.length = length;
            this.nextChar = nextChar;
        }

        public int getOffset() {
            return offset;
        }

        public int getLength() {
            return length;
        }

        public char getNextChar() {
            return nextChar;
        }

        @Override
        public String toString() {
            return String.valueOf(offset+""+length+""+nextChar);
        }
    }
}
