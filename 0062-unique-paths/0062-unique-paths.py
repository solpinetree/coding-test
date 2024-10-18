# a robot on an m x n grid
# only move either down or right
# return the num of possible unique paths 
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        
        directions = [(0, -1), (-1, 0)]
        dp = [[0] * n for _ in range(m)] 
        dp[0][0] = 1
        
        for i in range(m):
            for j in range(n):
                for dr, dc in directions:
                    prev_row = i + dr
                    prev_col = j + dc

                    if 0 <= prev_row < m and 0 <= prev_col < n:
                        dp[i][j] += dp[prev_row][prev_col]
                    
        return dp[m-1][n-1]