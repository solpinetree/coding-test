class Solution(object):
    def validateStackSequences(self, pushed, popped):
        """
        :type pushed: List[int]
        :type popped: List[int]
        :rtype: bool
        """
        # pushed : [1, 2, 3, 4, 5]
        # popped_stack = [1, 2, 3, 5, 4]
        # push(1)
        # push(2)
        # push(3)
        # push(4)
        # pop(2)
        
        stack = []
        popped_stack = popped[::-1]
        
        for i in range(len(pushed)):
            while stack and stack[-1] == popped_stack[-1]:
                stack.pop()
                popped_stack.pop()
            stack.append(pushed[i])
        # stack : [1, 2, 3, 5]
        # popped_stack = [1, 2, 3, 5]
        
        if stack != popped_stack:
            return False
        
        return True
        
        