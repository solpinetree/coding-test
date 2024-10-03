def solution(s):
    stack = []
    
    for p in s:
        if p == '(':
            stack.append(')')
        else:
            if not stack or stack.pop() != p:
                return False

    return not stack