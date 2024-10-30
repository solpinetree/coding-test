class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int row = 0;
        int col = 0;
        int num = 1;
        int direct= 0;
        
        while (num <= n*n) {
            answer[row][col] = num;
            int new_row = row + directions[direct%4][0];
            int new_col = col + directions[direct%4][1];
            
            if (num == n*n) {
                break;
            }
            
            if(0 <= new_row && new_row < n && 0 <= new_col && new_col < n &&
              answer[new_row][new_col] == 0) {
                row = new_row;
                col = new_col;
                num++;
            } else{
                direct++;
            }
        }
        
        return answer;
    }
}