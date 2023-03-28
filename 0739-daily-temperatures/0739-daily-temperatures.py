class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        res = []
        stack = []
        
        for i in reversed(range(len(temperatures))):
            temp = temperatures.pop()
            
            if stack:
                while stack and stack[-1][0]<=temp:
                    stack.pop()
                if stack:
                    res.append(stack[-1][1]-i)
                else:
                    res.append(0)
                stack.append([temp,i])
                                 
            else:
                res.append(0)
                stack.append([temp, i])
                                 
        return res[::-1]
            
                
            