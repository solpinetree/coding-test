class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        if len(s) != len(t):
            return False
        
        dict_s = dict()
        dict_t = dict()
        
        for value in s:
            if value in dict_s:
                dict_s[value] = dict_s[value] + 1
            else:
                dict_s[value] = 1;
            
        for value in t:
            if value in dict_t:
                dict_t[value] = dict_t[value] + 1
            else:
                dict_t[value] = 1;
        
        for key in dict_s:
            if key not in dict_t:
                return False
            elif dict_t[key] != dict_s[key]:
                return False
            
        return True