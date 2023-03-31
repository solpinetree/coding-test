class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        res = list(range(len(temperatures)))
        stack = []
        
        for day, temp in enumerate(temperatures):
            while stack and stack[-1][0] < temp:
                idx = stack.pop()[1]
                res[idx] = day-idx
            stack.append([temp, day])  
            
        for temp in stack:
            res[temp[1]] = 0
                                 
        return res
            
                
            