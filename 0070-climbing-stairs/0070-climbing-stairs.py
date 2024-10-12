class Solution(object):
    # it takes n steps to reach the top
    # each time you can either climb 1 or 2 steps
    # in how many distinct ways can you climb to the top?
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        # Base cases
        if n == 1:
            return 1
        if n == 2:
            return 2
        
        # Initialize the first two steps
        prev2 = 1  # 1 step to reach step 1
        prev1 = 2  # 2 steps to reach step 2
        
        # Iterate from step 3 to n
        for i in range(3, n + 1):
            current = prev1 + prev2  # Current step count is sum of the previous two steps
            prev2 = prev1  # Move the previous two steps forward
            prev1 = current
        
        return prev1  # The last computed step count is the result
