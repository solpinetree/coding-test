class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        
        for(int i=s.length()-1;i>=0;i--) {
            arr[s.length() - i - 1] = s.charAt(i) - '0';
        }
        
        return arr;
    }
}