class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        res = list(range(len(temperatures)))
        stack = []
        i = 0
        
        for temp in temperatures:
            while stack and stack[-1][0]<temp:
                idx = stack.pop()[1]
                res[idx] = i-idx
            stack.append([temp,i])  
            i = i + 1
            
        for temp in stack:
            res[temp[1]] = 0
                                 
        return res
            
                
            