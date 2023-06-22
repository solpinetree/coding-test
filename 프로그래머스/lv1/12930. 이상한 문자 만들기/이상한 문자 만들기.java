class Solution {
    public String solution(String s) {
        char[] s_arr = s.toCharArray();
        int cnt = 0;
        
        for(int i = 0; i < s.length(); i++){
            char cur_c = s_arr[i];
            
            if(cur_c == ' '){
                cnt = 0;
                continue;
            }
            
            if(cnt%2 == 0){
                s_arr[i] = Character.toUpperCase(s_arr[i]);
            } else{
                s_arr[i] = Character.toLowerCase(s_arr[i]);  
            }
            
            cnt++;
        }
        
        return new String(s_arr);
    }
}