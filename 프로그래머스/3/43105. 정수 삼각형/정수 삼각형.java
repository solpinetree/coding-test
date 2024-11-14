import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int[][] memo = new int[500][500];
        memo[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) 
                    memo[i][j] = memo[i-1][0] + triangle[i][j];
                else if(j == i)
                    memo[i][j] = memo[i-1][j-1] + triangle[i][j];
                else 
                    memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + triangle[i][j];
            }
        }
        
        int answer = 0;
        for(int n : memo[triangle.length - 1])
            answer = Math.max(n, answer);
        
        return answer;
    }
}