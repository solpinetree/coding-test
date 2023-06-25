class Solution {
    public boolean solution(String s) {
        
        int len = s.length();
        
        if(len!=4 && len!=6) return false;
        
        try{
            Integer.parseInt(s);
        }catch(Exception e){
            return false;
        }
        
        return true;
    }
}