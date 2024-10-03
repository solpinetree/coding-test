class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        
        dict_p = {
            "{" : "}",
            "[" : "]",
            "(" : ")",
        }
        
        stack = [s[0]]
        
        for i in range(1, len(s)):
            if s[i] not in dict_p.keys():
                if len(stack) == 0:
                    return False
                if (stack[-1] in dict_p.keys()) and (dict_p[stack[-1]] == s[i]):
                    stack.pop()
                    continue
            stack.append(s[i])
       
        if len(stack) != 0:
            return False
        
        return True
        