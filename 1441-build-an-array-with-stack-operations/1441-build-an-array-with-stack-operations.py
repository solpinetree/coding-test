class Solution(object):
    def buildArray(self, target, n):
        """
        :type target: List[int]
        :type n: int
        :rtype: List[str]
        """
        stack = []
        target_idx = 0
        
        for i in range(1, n+1):
            if target_idx < len(target):
                if target[target_idx] == i:
                    stack.append('Push')
                    target_idx += 1
                else:
                    stack.append('Push')
                    stack.append('Pop')
                
        return stack
        