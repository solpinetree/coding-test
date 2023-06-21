class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int sb_len = sb.length();
        answer = new int[sb_len];
        
        for(int i = 0; i < sb_len; i++){
            answer[i] = sb.charAt(sb_len-1-i) - '0';
        }
        
        return answer;
    }
}