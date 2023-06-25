class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            answer[0]++; 
            answer[1] += s.length() - s.replace("0", "").length();
            
            s = Integer.toString(s.replace("0", "").length(), 2);
        }
        
        return answer;
    }
}