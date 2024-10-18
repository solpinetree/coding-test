class Solution(object):
    # it takes n steps to reach the top
    # each time you can either climb 1 or 2 steps
    # return how many distinct ways u can climb to the top
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        dp = [-1] * (n+1)
        
        dp[0] = 1
        dp[1] = 1
        
        for i in range(2, n+1):
            dp[i] = dp[i-2] + dp[i-1] 
            
        return dp[n]
