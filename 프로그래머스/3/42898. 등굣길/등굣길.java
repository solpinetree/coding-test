class Solution {
    // 집에서 학교까지 가는 길은 mxn 크기의 격자모양
    // puddles : 물이 잠긴 지경의 좌표
    // return : 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수%1000000007
    private static int[][] memo;
    public int dp(int row, int col) {
        if(row < 1 || col < 1) return 0;
        
        if(memo[row][col] == -1) return 0;
        if(memo[row][col] != 0) return memo[row][col];
        return memo[row][col] = (dp(row -1, col) + dp(row, col-1))%1000000007;
    }
    
    public int solution(int m, int n, int[][] puddles) {
        memo = new int[n+1][m+1];
        memo[1][1] = 1;
        for(int[] p : puddles) memo[p[1]][p[0]] = -1;
        
        dp(n, m);
        return memo[n][m];
    }
}