class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        nums_dict = dict()
        
        for num in nums:
            nums_dict[num] = num
        
        for num in range(len(nums)):
            if num not in nums_dict:
                return num
        
        return len(nums)
        