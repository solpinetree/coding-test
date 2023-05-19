class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        my_dict = dict()
       
        for i in nums:
            if i not in my_dict: # 중복되는 숫자 없도록
                my_dict[i] = i
            
        longest = 0
        
        for i in my_dict:
            cnt = 1
            if i + 1 in my_dict and i -1 not in my_dict: # 연속되는 숫자의 첫번째 숫자만 저장
                while i + 1 in my_dict:
                    cnt += 1
                    i += 1
            longest = max(longest, cnt)
                
        return longest