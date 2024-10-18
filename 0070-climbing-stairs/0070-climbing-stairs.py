from collections import deque
class Solution(object):
    # it takes n steps to reach the top
    # each time you can either climb 1 or 2 steps
    # return how many distinct ways u can climb to the top
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        if n == 1:
            return 1
        if n == 2:
            return 2
        
        q = deque([(1, 1), (2, 2)])
        
        for i in range(3, n+1):
            stairs, ways = q.popleft()
            q.append((i, ways + q[0][1]))
            
        while q:
            answer = q.popleft()[1]
            
        return answer
