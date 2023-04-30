class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        my_dict = dict()
        
        if len(nums) == 0 :
            return 0
        
        for i in nums:
            if i not in my_dict: # 중복되는 숫자 없도록
                my_dict[i] = i
            
        max_len = 1
        for i in my_dict:
            res = 1
            if i + 1 in my_dict and i -1 not in my_dict: # 연속되는 숫자의 첫번째 숫자만 저장
                res = 1
                while i + 1 in my_dict:
                    res = res + 1
                    i = i + 1
            if max_len < res:
                max_len = res
                
        return max_len