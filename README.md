# 메세지 파싱하기
    16진수로 오는 메세지를 규칙에 따라 파싱한다.
    
## 파싱 규칙
### 헤더 파싱
    1. 14 byte를 읽어온다.
    2. 앞에 4byte는 메세지의 총 길이이다.
    3. w-bit와 Stream Fuction을 파싱한다.
    4. 시스템 바이트를 읽어온다.
### 메세지 읽어온 후 2진법으로 변환하는 규칙
    1. 메세지에서 숫자를 읽어온다.
    2. 각 16진수를 공백에 상관없이 한 자리씩 분리한 뒤, 각 자리의 16진수를 4비트짜리 2진수로 변환한다.
    3. 각 숫자의 2진수 결과를 4비트씩 2개씩 이어붙인다.
    4. 각 숫자는 공백으로 구분한다.
### 파싱 규칙
    1. 처음 나오는 2진수를 6비트와 2비트로 나눈다.
    2. 앞에 6비트로 데이터 타입을 판단하고 2비트는 Length Byte를 판단한다.
    3. Length Byte만큼 수를 읽어온다 
    4. 공백으로 숫자를 구분하며 읽어온 수는 아이템의 갯수이다.
    5. 아이템의 갯수만큼 2진수를 읽어온다.
    6. 데이터 타입에 따라 수를 변환한다.
    7. 이 과정이 끝나면 다시 반복한다.
 
 
