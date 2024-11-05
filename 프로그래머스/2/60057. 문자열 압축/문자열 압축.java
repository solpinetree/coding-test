import java.util.*;
// return : 압축하여 표현한 문자열 중 가장 짧은 것의 길이
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1;i<=s.length();i++){
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int cnt = 1;
            sb.append(prev);
            for(int j=i;j<s.length();j+=i) {
                String tmp = s.substring(j, j+i > s.length() ? s.length() : j+i);
                if(prev.equals(tmp)) {
                    cnt++;
                    if (j+i >= s.length()) {
                        sb.append(cnt);
                    }
                } else {
                    if(cnt!=1)  sb.append(cnt);
                    sb.append(tmp);
                    prev = tmp;
                    cnt = 1;
                }
            }
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}