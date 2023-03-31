class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        res = []
        stack = []
        i = 0
        
        for temp in temperatures[::-1]:
            if stack:
                while stack and stack[-1][0]<=temp:
                    stack.pop()
                if stack:
                    res.append(i-stack[-1][1])
                else:
                    res.append(0)
                stack.append([temp,i])
                                 
            else:
                res.append(0)
                stack.append([temp, i])
            i = i + 1
                                 
        return res[::-1]
            
                
            