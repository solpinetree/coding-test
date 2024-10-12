class Solution(object):
    # it takes n steps to reach the top
    # each time you can either climb 1 or 2 steps
    # in how many distinct ways can you climb to the top?
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        if n == 1:
            return 1
        if n == 2:
            return 2
        
        prev2 = 1
        prev1 = 2
            
        for i in range(3, n + 1):
            current = prev2 + prev1
            prev2 = prev1
            prev1 = current
            
        return prev1
