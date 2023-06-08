class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        temp = dict()
        max = 0
        max_value = 0
        
        for key, value in enumerate(nums):
            if value in temp:
                temp[value] = temp[value] + 1 
            else: 
                temp[value] = 1
            
            if temp[value] > max:
                max = temp[value]
                max_value = value
        
        return max_value
        