from collections import deque

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if(len(s)%2 == 1):
            return False;
        
        d = {}
        d['('] = ')'
        d['['] = ']'
        d['{'] = '}'
        
        q = deque()
        for c in s:
            if c in ['(','[','{']:
                q.append(c)
            else:
                try:
                    if d[q.pop()] != c:
                        return False
                except:
                    return False
        if len(q) != 0:
            return False
        return True