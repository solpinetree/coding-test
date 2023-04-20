class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        my_dict = dict()
        for i, j in enumerate(nums):
            if target - j in my_dict:
                return [my_dict[target-j], i]
            my_dict[j] = i
            