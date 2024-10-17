# nums : unsorted array of integers
# return the len of the longest consecutive elements sequence
class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        dict = {}
        
        for num in nums:
            if num in dict:
                continue
                
            dict[num] = [num, num]
            if num - 1 in dict and num + 1 in dict:
                s = dict[num-1][0]
                m = dict[num+1][1]
                dict[s][1] = m
                dict[m][0] = s
            elif num -1 in dict:
                s = dict[num-1][0]
                dict[s][1] = num
                dict[num][0] = s
            elif num + 1 in dict:
                m = dict[num+1][1]
                dict[m][0] = num
                dict[num][1] = m
        
        answer = 0
        
        for key in dict:
            answer = max(answer, dict[key][1] - dict[key][0] + 1)
            
        return answer
        