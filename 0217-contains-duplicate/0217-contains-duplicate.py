class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        
        temp = dict()
        
        for num in nums:
            if num in temp:
                return True
            temp[num] = num
        
        return False
        