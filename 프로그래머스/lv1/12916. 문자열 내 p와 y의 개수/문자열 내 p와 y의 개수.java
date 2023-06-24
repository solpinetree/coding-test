class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int cnt_p = 0;
        int cnt_y = 0;
        
        for(char c : s.toCharArray()){
            if(c == 'p' || c == 'P'){
                cnt_p++;
            }else if(c == 'y' || c == 'Y'){
                cnt_y++;
            }
        }
        
        if(cnt_p == cnt_y){
            return true;
        }

        return false;
    }
}