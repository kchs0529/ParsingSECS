package com.drimsys.parsing;

import java.util.ArrayList;

public class Convert {

	// 읽어온 16진수를 2진수로 변환하는 메소드
    public static String hexToBinary(char hexChar) {
        // 16진수를 정수로 변환
        int decimal = Character.digit(hexChar, 16);
        if (decimal == -1) {
            throw new IllegalArgumentException("유효하지 않은 16진수 문자: " + hexChar);
        }
        // 2진수로 변환 (4자리로 패딩)
        return String.format("%4s", Integer.toBinaryString(decimal)).replace(' ', '0');
    }
    
    //2진수를 16진수로 변환
    public static String binaryToHex(String binary) {
        // 2진수가 4비트씩 나누어져야 하므로 4비트로 패딩합니다.
        int length = binary.length();
        int paddingLength = 4 - (length % 4);
        if (paddingLength != 4) {
            // 부족한 비트를 '0'으로 채워서 4비트로 만듦
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paddingLength; i++) {
                sb.append("0");
            }
            binary = sb.toString() + binary;
        }

        StringBuilder hex = new StringBuilder();

        // 4비트씩 끊어서 16진수로 변환
        for (int i = 0; i < binary.length(); i += 4) {
            String fourBits = binary.substring(i, i + 4);
            // 4비트 문자열을 10진수로 변환
            int decimal = Integer.parseInt(fourBits, 2);
            // 10진수를 16진수로 변환하고 그 결과를 hex 문자열에 추가
            hex.append(Integer.toHexString(decimal).toUpperCase());
        }

        return hex.toString();
    }
    
    //변환된 String을 2개씩 붙이고 공백으로 구분하기
    public static ArrayList<String> AttachBinary(ArrayList<String> parsingDataList) {
        ArrayList<String> convertList = new ArrayList<>();  // 새로운 리스트 생성

        // parsingDataList를 2개씩 합쳐서 공백으로 구분하여 convertList에 추가
        for (int i = 0; i < parsingDataList.size() - 1; i += 2) {
            String combined = parsingDataList.get(i) + parsingDataList.get(i + 1);  // 2개씩 합침
            convertList.add(combined);  // convertList에 추가
        }

        // 홀수 개일 경우 마지막 하나 남은 값 처리
        if (parsingDataList.size() % 2 != 0) {
            convertList.add(parsingDataList.get(parsingDataList.size() - 1));  // 마지막 값 추가
        }

        return convertList;  // convertList 반환
    }
}
