import java.util.*;
class Solution {
    // my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return
    public String solution(String my_string) {
        String answer = "";
        HashSet<Character> set = new HashSet<>();
        
        for(char c : my_string.toCharArray()) {
            if(set.contains(c)) continue;
            set.add(c);
            answer += String.valueOf(c);
        }
        
        return answer;
    }
}