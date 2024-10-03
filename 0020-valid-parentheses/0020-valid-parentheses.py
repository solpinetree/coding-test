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
        
        stack = []
        
        for p in s:
            if p in dict_p.keys():
                stack.append(dict_p[p])
            elif not stack or stack.pop() != p:
                return False
            
        return not stack
        