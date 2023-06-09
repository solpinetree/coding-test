class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums) 
        total = n*((n+1)/2.0) 
        
        for num in nums:
            total = total - num
        
        return int(total)
        