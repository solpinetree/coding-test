class Solution(object):
    def buildArray(self, target, n):
        """
        :type target: List[int]
        :type n: int
        :rtype: List[str]
        """
        stack = []
        target_set = set(target) # Set 을 사용하여 검색을 O(1)로 수행
        
        for i in range(1, n+1):
            if i > target[-1]: # target의 마지막 숫자를 넘어서면 종료
                break
            stack.append('Push')
            if i not in target_set:
                stack.append('Pop') # target에 없는 경우에만 Pop 추가
                
        return stack
        