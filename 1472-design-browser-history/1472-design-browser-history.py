class BrowserHistory(object):

    def __init__(self, homepage):
        """
        :type homepage: str
        """
        self.__history = []
        self.__history.append(homepage)
        self.__idx = 0
        

    def visit(self, url):
        """
        :type url: str
        :rtype: None
        """
        del self.__history[self.__idx+1:len(self.__history)]
        self.__idx += 1
        self.__history.append(url)
        

    def back(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        if self.__idx - steps < 0 :
            self.__idx = 0
        else:
            self.__idx = self.__idx - steps
            
        return self.__history[self.__idx]
        
    def forward(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        if self.__idx + steps >= len(self.__history):
            self.__idx = len(self.__history)-1
        else:
            self.__idx = self.__idx +steps

        return self.__history[self.__idx]


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)