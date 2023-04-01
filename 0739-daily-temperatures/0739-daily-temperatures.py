class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        res = [0] * len(temperatures)
        stack = []
        
        for cur_day, cur_temp in enumerate(temperatures):
            while stack and stack[-1][1] < cur_temp:
                prev_day = stack.pop()[0]
                res[prev_day] = cur_day - prev_day
            stack.append((cur_day, cur_temp))  
    
                                 
        return res
            
                
            