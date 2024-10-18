# cost[i] = the cost of i(th) step on a staircase
# once u pay the cost, u can either climb one or two steps
# u can start from the step with index 0 or index 1
# return the minimum cost to reach the top of the floor
class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        n = len(cost)
        dp = [0] * (n+1)
        
        dp[0] = 0
        dp[1] = 0
        
        for i in range(2, n + 1):
            dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
            
        return dp[n]