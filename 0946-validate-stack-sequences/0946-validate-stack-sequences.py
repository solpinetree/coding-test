class Solution(object):
    def validateStackSequences(self, pushed, popped):
        """
        :type pushed: List[int]
        :type popped: List[int]
        :rtype: bool
        """
        
        stack = []
        pop_idx = 0 # popped 리스트의 현재 인덱스를 추적
        
        for value in pushed:
            stack.append(value) # 스택에 요소 추가
            # 스택의 top이 pop 리스트의 현재 요소와 일치할 경우 pop
            while stack and stack[-1] == popped[pop_idx]:
                stack.pop()
                pop_idx += 1
        
        return not stack
        
        