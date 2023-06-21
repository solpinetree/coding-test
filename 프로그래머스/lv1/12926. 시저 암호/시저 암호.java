class Solution {
    public char push(char c, int n){
        if(Character.isLowerCase(c)){ 
            if(c + n > 'z'){
                int remaining_val = (c + n) % 'z';
                return (char)((int)'a' + remaining_val - 1);
            }
        }else if(Character.isUpperCase(c)){ 
            if(c + n > 'Z'){
                int remaining_val = (c + n) % 'Z';
                return (char)((int)'A' + remaining_val - 1);
            }
        }
        
        return (char)(c + n);
    }
    public String solution(String s, int n) {
        char[] s_arr = s.toCharArray();
        
        for(int i = 0; i < s_arr.length; i++){
            char cur_c = s_arr[i];
            
            if(cur_c == ' ')    continue;
            s_arr[i] = push(cur_c, n);
        }
        
        return new String(s_arr);
    }
}