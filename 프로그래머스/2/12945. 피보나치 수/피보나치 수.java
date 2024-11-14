class Solution {
    public int solution(int n) {
        long[] memo = new long[n+1];
        memo[0] = 0l;
        memo[1] = 1l;
        
        for(int i = 2; i <= n; i++) {
            memo[i] = memo[i-1]%1234567l + memo[i-2]%1234567l;
        }
        
        return (int)(memo[n]%1234567);
    }
}