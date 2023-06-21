class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()){
            return false;
        }
        
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : s_arr){
            int c_cnt = map.get(c) == null ? 0 : map.get(c);
            map.put(c, c_cnt + 1);
        }
        
        for(char c : t_arr){
            int c_cnt = map.get(c) == null ? 0 : map.get(c);
            if(c_cnt == 0){
                return false;
            }else{
                map.put(c, c_cnt - 1);
            }
        }
        
        return true;
    }
}