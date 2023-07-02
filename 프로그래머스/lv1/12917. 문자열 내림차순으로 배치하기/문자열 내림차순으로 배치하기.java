import java.util.*;

class Solution {
    public String solution(String s) {        
        // StringBuilder - appendCodePoint(int codePoint) 
        // : 해당 아스키코드의 character를 추가한다.
        return s.chars()  // 문자열에서 chars() 메소드를 호출하면 IntStream 이 반환됨
            .boxed()
            .sorted((v1, v2) -> v2 - v1)
            .collect(
                StringBuilder::new, // supplier - 반환할 객체
                StringBuilder::appendCodePoint, // accumulator - stream의 원소를 어떻게 누적할지
                StringBuilder::append   // combiner
            ).toString();
    }
}