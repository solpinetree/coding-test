class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        
        d = {}
        d['('] = ')'
        d['['] = ']'
        d['{'] = '}'
        
        stack = []
        for c in s:
            if c in ['(','[','{']:
                stack.append(c)
            else:
                try:
                    if d[stack.pop()] != c:
                        return False
                except:
                    return False
        if len(stack) != 0:
            return False
        return True