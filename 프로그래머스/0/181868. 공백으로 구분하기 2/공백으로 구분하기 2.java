import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] str = my_string.trim().split(" ");
        List<String> answer = new ArrayList<>();
        
        for (String s : str) {
            if (!s.equals("")) {
                answer.add(s);
            }
        }
        
        return answer.toArray(new String[0]);
    }
}