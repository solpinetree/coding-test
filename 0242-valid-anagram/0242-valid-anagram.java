class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()){
            return false;
        }
        
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        
        int[] cnt = new int[100];
        
        for(char c : s_arr){
            cnt[c-'a']++;
        }
        
        for(char c : t_arr){
            if(cnt[c-'a']==0){
                return false;
            }
            cnt[c-'a']--;
        }
        
        return true;
    }
}