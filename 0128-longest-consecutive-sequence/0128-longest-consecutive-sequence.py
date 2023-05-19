class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        num_set = set(nums)
        longest = 0
        
        for i in num_set:
            cnt = 1
            if i + 1 in num_set and i -1 not in num_set: # 연속되는 숫자의 첫번째 숫자만 저장
                while i + 1 in num_set:
                    cnt += 1
                    i += 1
            longest = max(longest, cnt)
                
        return longest