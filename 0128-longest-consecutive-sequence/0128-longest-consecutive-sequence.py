class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        my_dict = dict()
        st_dict = dict()
        
        if len(nums) == 0 :
            return 0
        
        for i in nums:
            if i not in my_dict: # 중복되는 숫자 없도록
                my_dict[i] = i
        
        # [0, 2, 4, 5, 6, 7, -1, -8, -4, -3, -2]
        # [0, -1, -2, -3, -4]
        # [-3, -4, -1, -2, 0]
        # [4, 5, 6, 7]
            
        for i in my_dict:
            if i + 1 in my_dict and i -1 not in my_dict:
                st_dict[i] = i
                
        res0 = 1
        for i in st_dict:
            res = 1
            while i+1 in my_dict:
                res = res + 1
                i = i + 1
            if res0 < res:
                res0 = res
                
        return res0