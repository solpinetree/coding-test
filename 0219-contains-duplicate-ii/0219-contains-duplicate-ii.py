class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        temp = dict()
        
        for key, val in enumerate(nums):
            if val in temp:
                if key - temp[val] <= k:
                    return True
                else:
                    del temp[val]
            temp[val] = key
            
        return False
        