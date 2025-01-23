package com.drimsys.parsing;

import java.util.ArrayList;

public class Parsing {
	
	private static int lCount = 0;
	
	public static void Structure(String dataType,int numberOfItem, String parsingResult) {
		
		String repeat = ("    ").repeat(lCount);
		//L이 아니라면 들여쓰기
		if("L".equals(dataType)) {
			System.out.println(repeat+dataType+","+numberOfItem);
			lCount++;
		}else {
			System.out.println(repeat+dataType+","+numberOfItem+" "+parsingResult);
		}
		
	}
	
	//List
	public static int ListType(int lengthByte, ArrayList<String> convertResult, int startIndex) {
        int indexSum = 0;
        String itemNum="";
        // LengthByte 만큼 데이터를 읽어옴
        for (int i = 0; i < lengthByte; i++) {
            // 읽어온 값이 아이템이므로 이를 출력 (2진수 값)
            itemNum = convertResult.get(startIndex + i);
        }
        Structure("L",Integer.parseInt(itemNum,2),null);
        return indexSum;
    }
	
	//Binary
	public static int BinaryType(int lengthByte, ArrayList<String> convertResult, int startIndex) {
		
		StringBuilder result = new StringBuilder();
	    int indexSum = 0;
	    String itemNum = "";
	    int itemBodyIndex = startIndex;
	    for (int i = 0; i < lengthByte; i++) {
	        itemNum = convertResult.get(itemBodyIndex + i);
	        
	        result.append(convertResult.get(Integer.parseInt(itemNum)+itemBodyIndex)).append(" "); // 바이너리 값을 그대로 출력
	        
	        indexSum += Integer.parseInt(itemNum, 2); // 바이너리 값을 10진수로 변환하여 indexSum에 더함
	    }
	    Structure("B",Integer.parseInt(itemNum,2),result.toString());
	    return indexSum;
	}
	
	//signedInt-1byte
	public static int I1Type(int lengthByte, ArrayList<String> convertResult, int startIndex) {
		int indexSum = 0;
		int itemBodyIndex = startIndex;
		String item = "";
		StringBuilder parsingResult = new StringBuilder();
		for (int i = 0; i < lengthByte; i++) {
            item = convertResult.get(itemBodyIndex+ i);
            indexSum+=Integer.parseInt(item, 2);
            for(int j=1;j<=Integer.parseInt(item, 2);j++) {
            	parsingResult.append(Convert.binaryToHex(convertResult.get(itemBodyIndex+j)));
            }
        }
		long signedInt1Value = Integer.parseInt(parsingResult.toString(),16);
		Structure("I1",Integer.parseInt(item, 2),String.valueOf(signedInt1Value));
		return indexSum;
	}
	
	//signedInt-2byte
	public static int I2Type(int lengthByte, ArrayList<String> convertResult, int startIndex) {
		int indexSum = 0;
		int itemBodyIndex = startIndex;
		String item = "";
		StringBuilder parsingResult = new StringBuilder();
		for (int i = 0; i < lengthByte; i++) {
            item = convertResult.get(itemBodyIndex+ i);
            indexSum+=Integer.parseInt(item, 2);
            for(int j=1;j<=Integer.parseInt(item, 2);j++) {
            	parsingResult.append(Convert.binaryToHex(convertResult.get(itemBodyIndex+j)));
            }
        }
		long signedInt2Value = Integer.parseInt(parsingResult.toString(),16);
		Structure("I2",Integer.parseInt(item, 2),String.valueOf(signedInt2Value));
		return indexSum;
	}
	
	//signedInt-4byte
	public static int I4Type(int lengthByte, ArrayList<String> convertResult, int startIndex) {
		int indexSum = 0;
		int itemBodyIndex = startIndex;
		String item = "";
		StringBuilder parsingResult = new StringBuilder();
		for (int i = 0; i < lengthByte; i++) {
            item = convertResult.get(itemBodyIndex+ i);
            indexSum+=Integer.parseInt(item, 2);
            for(int j=1;j<=Integer.parseInt(item, 2);j++) {
            	parsingResult.append(Convert.binaryToHex(convertResult.get(itemBodyIndex+j)));
            }
        }
		long signedInt4Value = Integer.parseInt(parsingResult.toString(),16);
		Structure("I4",Integer.parseInt(item, 2),String.valueOf(signedInt4Value));
		return indexSum;
	}
	//signedInt-8byte
	public static int I8Type(int lengthByte, ArrayList<String> convertResult, int startIndex) {
		int indexSum = 0;
		int itemBodyIndex = startIndex;
		String item = "";
		StringBuilder parsingResult = new StringBuilder();
		for (int i = 0; i < lengthByte; i++) {
            item = convertResult.get(itemBodyIndex+ i);
            indexSum+=Integer.parseInt(item, 2);
            for(int j=1;j<=Integer.parseInt(item, 2);j++) {
            	parsingResult.append(Convert.binaryToHex(convertResult.get(itemBodyIndex+j)));
            }
        }
		long signedInt8Value = Integer.parseInt(parsingResult.toString(),16);
		Structure("I8",Integer.parseInt(item, 2),String.valueOf(signedInt8Value));
		return indexSum;
	}		
		
	
	//ASCII
	public static int AsciiType(int lengthByte, ArrayList<String> convertResult, int startIndex) {
		int indexSum = 0;
		int itemBodyIndex = startIndex;
		String item = "";
		StringBuilder parsingResult = new StringBuilder();
		for(int i=0;i<lengthByte;i++) {
			item = convertResult.get(itemBodyIndex+i);
			indexSum+=Integer.parseInt(item, 2);
			for(int j=1;j<=Integer.parseInt(item, 2);j++) {
				int decimalValue = Integer.parseInt(convertResult.get(itemBodyIndex+j),2);
		        // 10진수를 아스키 문자로 변환
		        char asciiChar = (char) decimalValue;
		        parsingResult.append(asciiChar);
			}		       
		}
		Structure("A",Integer.parseInt(item, 2),parsingResult.toString());
		return indexSum;
	}
	
	//unsignedInt-1byte
	public static int U1Type(int lengthByte, ArrayList<String> convertResult, int startIndex) {
		int indexSum = 0;
		int itemBodyIndex = startIndex;
		String item = "";
		StringBuilder parsingResult = new StringBuilder();
		for (int i = 0; i < lengthByte; i++) {
            item = convertResult.get(itemBodyIndex+ i);
            indexSum+=Integer.parseInt(item, 2);
            for(int j=1;j<=Integer.parseInt(item, 2);j++) {
            	parsingResult.append(Convert.binaryToHex(convertResult.get(itemBodyIndex+j)));
            }
        }
		long unsignedInt1Value = Integer.parseInt(parsingResult.toString(),16);

		Structure("U1",Integer.parseInt(item, 2),String.valueOf(unsignedInt1Value));
		
		return indexSum;
	}
	
	//unsignedInt-2byte
	public static int U2Type(int lengthByte, ArrayList<String> convertResult, int startIndex) {

		int indexSum = 0;
		int itemBodyIndex = startIndex;
		String item = "";
		StringBuilder parsingResult = new StringBuilder();
		for (int i = 0; i < lengthByte; i++) {
            item = convertResult.get(itemBodyIndex+ i);
            indexSum+=Integer.parseInt(item, 2);
            for(int j=1;j<=Integer.parseInt(item, 2);j++) {
            	parsingResult.append(Convert.binaryToHex(convertResult.get(itemBodyIndex+j)));
            }
        }
		long unsignedInt2Value = Integer.parseInt(parsingResult.toString(),16);

		Structure("U2",Integer.parseInt(item, 2),String.valueOf(unsignedInt2Value));
		
		return indexSum;
	}
	

	//unsignedInt-4byte
	public static int U4Type(int lengthByte, ArrayList<String> convertResult, int startIndex) {
		int indexSum = 0;
		int itemBodyIndex = startIndex;
		String item = "";
		StringBuilder parsingResult = new StringBuilder();
		for (int i = 0; i < lengthByte; i++) {
            item = convertResult.get(itemBodyIndex+ i);
            indexSum+=Integer.parseInt(item, 2);
            for(int j=1;j<=Integer.parseInt(item, 2);j++) {
            	parsingResult.append(Convert.binaryToHex(convertResult.get(itemBodyIndex+j)));
            }
        }
		long unsignedInt4Value = Integer.parseInt(parsingResult.toString(),16);

		Structure("U4",Integer.parseInt(item, 2),String.valueOf(unsignedInt4Value));
		
		return indexSum;
	}
	
	//unsignedInt-8byte
	public static int U8Type(int lengthByte, ArrayList<String> convertResult, int startIndex) {
		int indexSum = 0;
		int itemBodyIndex = startIndex;
		String item = "";
		StringBuilder parsingResult = new StringBuilder();
		for (int i = 0; i < lengthByte; i++) {
            item = convertResult.get(itemBodyIndex+ i);
            indexSum+=Integer.parseInt(item, 2);
            for(int j=1;j<=Integer.parseInt(item, 2);j++) {
            	parsingResult.append(Convert.binaryToHex(convertResult.get(itemBodyIndex+j)));
            }
        }
		long unsignedInt8Value = Long.parseLong(parsingResult.toString(),16);
		Structure("U8",Integer.parseInt(item, 2),String.valueOf(unsignedInt8Value));
		return indexSum;
	}
}


