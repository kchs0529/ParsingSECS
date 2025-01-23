package com.drimsys.parsing;

import java.util.ArrayList;

public class Datatype {
	
	//처음나오는 값을 6개와2개로나눈다
	public static String[] splitFirst6AndNext2(String input) {
		
        // 처음 6자리와 그 다음 2자리 추출
        String first6 = input.substring(0, 6);
        String next2 = input.substring(6, 8);

        // 결과를 배열로 반환
        return new String[] {first6, next2};
    }
	
	//값에 따라 어떤 데이터타입인지 판단하는 메소드
	public static int determineDataType(String input, int lengthByte, ArrayList<String> convertResult, int startIndex) {
		int sum = 0;
        // 데이터 타입 판단
        switch (input) {
            case "000000":
                return Parsing.ListType(lengthByte, convertResult, startIndex);
            case "001000":
                return Parsing.BinaryType(lengthByte, convertResult, startIndex);
            case "001001":
                return 0;
            case "010000":
                return Parsing.AsciiType(lengthByte, convertResult, startIndex);
            case "011001":
            	return Parsing.I1Type(lengthByte, convertResult, startIndex);
            case "011010":
            	return Parsing.I2Type(lengthByte, convertResult, startIndex);
            case "011100":
            	return Parsing.I4Type(lengthByte, convertResult, startIndex);
            case "011000":
            	return Parsing.I8Type(lengthByte, convertResult, startIndex);
            case "101001":
                return Parsing.U1Type(lengthByte, convertResult, startIndex);    
            case "101010":
                return Parsing.U2Type(lengthByte, convertResult, startIndex);
            case "101100":
                return Parsing.U4Type(lengthByte, convertResult, startIndex);
            case "101000":
                return Parsing.U8Type(lengthByte, convertResult, startIndex);
            	
            default:
               return sum;
        }
		
    }

}
