import java.util.*;

class Solution {
    // participant : 마라톤에 참여한 선수들의 이름이 담긴 배열
    // completion : 완주한 선수들의 이름이 담긴 배열
    // return : 완주하지 못한 선수의 이름
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (String p : participant) {
            if(map.containsKey(p) && map.get(p) > 0) {
                map.put(p, map.get(p) - 1);
            } else {
                return p;
            }
        }
        
        return answer;
    }
}