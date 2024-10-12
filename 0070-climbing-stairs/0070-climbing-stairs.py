from collections import deque

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
        
        q = deque([(2, 2), (3, 3)]) # (step, number_of_ways)
        
        for i in range(4, n + 1):
            step2 = q.popleft() # i - 2
            step1 = q[0] # i - 1
            current_ways = step1[1] + step2[1]
            q.append((i, current_ways))
            
        return q[-1][1]
