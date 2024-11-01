import java.util.*;
class Solution {
    public int[] solution(String s) {
        int zero = 0;
        int cnt = 0;
        while(!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '0') zero++;
                else sb.append(s.charAt(i));  
            }
            s = Integer.toString(sb.toString().length(), 2);
            cnt++;
        }
        
        return new int[]{cnt, zero};
    }
}