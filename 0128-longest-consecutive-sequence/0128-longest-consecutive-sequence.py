# nums : unsorted array of integers
# return the len of the longest consecutive elements sequence
class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        num_set = set(nums)
        max_length = 0
        
        for num in num_set:
            # num - 1이 num_set에 없을 경우만 연속된 시퀀스의 시작점으로 간수
            if num - 1 not in num_set: 
                current_num = num
                current_streak = 1
                
                while current_num + 1 in num_set:
                    current_num += 1
                    current_streak += 1
                    
                # 가장 긴 시퀀스를 저장
                max_length = max(max_length, current_streak)
            
        return max_length
        