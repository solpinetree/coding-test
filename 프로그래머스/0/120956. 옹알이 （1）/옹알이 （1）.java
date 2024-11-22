import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        HashMap<Character, String> map = new HashMap<>();
        map.put('a', "aya"); map.put('y', "ye"); map.put('w', "woo"); map.put('m', "ma");
        
        for(String b : babbling) {
            while(b.length() > 0) {
                char c = b.charAt(0);
                if(!map.containsKey(c)) break;
                int before = b.length();
                b = b.replaceAll("^" + map.get(c), "");
                if(before == b.length()) break;
            }
            if(b.length() == 0) answer++;
        }
        
        return answer;
    }
}