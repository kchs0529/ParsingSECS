//static 메소드는 인스턴스 생성을 하지않고 클래스 이름을 붙여서 호출하면된다.
package com.drimsys.parsing;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParsingMain {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("parsingdata.txt");
        int data;
        
        ArrayList<String> convertDataList = new ArrayList<>();
        // 파일 읽기 및 처리
        while ((data = reader.read()) != -1) {
            char dataToChar = (char) data;

            // 공백은 무시
            if (Character.isWhitespace(dataToChar)) {
                continue;
            }
            
            String convertData = Convert.hexToBinary(dataToChar);
            convertDataList.add(convertData);           
        }
        
        ArrayList<String> convertResult = Convert.AttachBinary(convertDataList);
        
        int index = 0;
        int length = 0;
        int stream = 0;
        int function = 0;
        int wBit = 0;
        StringBuilder sb = new StringBuilder();
        while(index<14) {
        	//header 파싱 추가
        	if(index<4) {
        		sb.append(convertResult.get(index));
        		length = Integer.parseInt(sb.toString(), 2);
        	}
        	
        	if(index==4) {
        		String str = convertResult.get(index);
        		wBit = Integer.parseInt(str.substring(0, 4),2);
        		stream = Integer.parseInt(str.substring(4),2);
        	}
        	
        	if(index==5) {
        		function = Integer.parseInt(convertResult.get(index), 2);
        	}
        	
        	index++;
        }
        System.out.println("총 길이: "+length+" "+"W-Bit: "+wBit+"Bit S"+stream+"F"+function);
        
        while(index>=14&&index<convertDataList.size()/2) { // 각각의 문자를 1개씩읽어 온 후 2개로 합쳤으므로 절반으로 나눠줘야 갯수가 나온다.
        	String input = convertResult.get(index);
        	String[] splitData = Datatype.splitFirst6AndNext2(input);
        	String dataType = splitData[0]; 
        	int lengthByte = Integer.parseInt(splitData[1], 2);
        	index=index+lengthByte+Datatype.determineDataType(dataType, lengthByte, convertResult, index + 1)+1;
        }
        
        reader.close(); // 파일 닫기
  
    }

}
