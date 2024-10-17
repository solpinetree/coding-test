# return indices of the two numbers such that they add up to target
from collections import defaultdict

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = defaultdict(list)
        
        for i, n in enumerate(nums):
            dict[n].append(i)
            
        
        for key1 in dict:
            key2 = target - key1
            if key1 == key2 and len(dict[key1]) > 1:
                return [dict[key1][0], dict[key1][1]]
            if key2 in dict and dict[key2] != dict[key1]:
                return [dict[key1][0], dict[key2][0]]