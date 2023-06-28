import java.util.*;

class Solution {
    private List<String> split(String s, int length){
        // 설정된 길이만큼 문자열을 잘라 낸 token의 배열 생성
        List<String> tokens = new ArrayList<>();
        
        for(int start = 0; start < s.length(); start = start+length){
            int end = start + length;
            if(end > s.length())
                end = s.length();
            
            tokens.add(s.substring(start, end));
        }
        
        return tokens;
    }
    
    private int compress(String s, int length){
        // 문자열을 비교하며 token의 배열을 하나의 문자열로 압축
        List<String> tokens = split(s, length);
        int res = 0;
        String prev = "";
        int prev_cnt = 0;
        
        for(String token : tokens){
            if(prev.equals("") || token.equals(prev)) prev_cnt++;
            else{
                res = String.valueOf(prev_cnt == 1 ? "" : prev_cnt).length()+ res + prev.length();
                
                prev_cnt = 1;
            }
            
            prev = token;
        }
        
        res = String.valueOf(prev_cnt == 1 ? "" : prev_cnt).length()+ res + prev.length();
        
        return res;
    }
    
    public int solution(String s) {
        int min = 1000;
        
        // 1 부터 s의 길이만큼 자를 문자열의 길이를 설정하며 반복
        for(int i=1; i <= s.length();i++){
            int cur_len = compress(s, i);
            
            // 압축된 문자열 중 가장 짧은 길이를 반환
            if(min > cur_len) min = cur_len;
        }
        
        return min;
    }
}