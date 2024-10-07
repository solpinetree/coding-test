from collections import deque

class MyStack(object):

    def __init__(self):
        self.q1 = deque()
        self.q2 = deque()

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.q1.append(x)

    def pop(self):
        """
        :rtype: int
        """
        self.q2 = deque()
        length = len(self.q1)
        count = 0
        tmp = 0
        while self.q1:
            count += 1
            if count == length:
                tmp = self.q1.popleft()
            else:
                self.q2.append(self.q1.popleft())
        self.q1 = self.q2
        return tmp

    def top(self):
        """
        :rtype: int
        """
        self.q2 = deque()
        length = len(self.q1)
        count = 0
        tmp = 0
        while self.q1:
            count += 1
            temp = self.q1.popleft()
            if count == length:
                tmp = temp
            self.q2.append(temp)
        self.q1 = self.q2
        return tmp
        

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.q1) == 0
        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()