class CustomStack(object):

    def __init__(self, maxSize):
        """
        :type maxSize: int
        """
        self.stack = [None] * maxSize
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        for i, s in enumerate(self.stack):
            if s == None:
                self.stack[i] = x
                break
                
    def pop(self):
        """
        :rtype: int
        """
        idx = -1
        for i, s in enumerate(self.stack):
            if s != None:
                idx = i
        
        if idx == -1:
            return -1
        
        result = self.stack[idx]
        self.stack[idx] = None
        return result

    def increment(self, k, val):
        """
        :type k: int
        :type val: int
        :rtype: None
        """
        for i, s in enumerate(self.stack):
            if s != None and i < k: 
                self.stack[i] += val

# Your CustomStack object will be instantiated and called as such:
# obj = CustomStack(maxSize)
# obj.push(x)
# param_2 = obj.pop()
# obj.increment(k,val)