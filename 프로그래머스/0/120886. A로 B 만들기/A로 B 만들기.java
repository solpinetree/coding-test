import java.util.*;
class Solution {
    // before의 순서를 바꾸어 after를 만들 수 있으면 1, 없으면 0
    public int solution(String before, String after) {
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for(char c : before.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        for(char c : after.toCharArray()) {
            if(freq.getOrDefault(c, 0) == 0) return 0;
            freq.put(c, freq.get(c) - 1);
        }
        
        return 1;
    }
}