class Node:
    def __init__(self, value=0, prev=None, next=None):
        self.value = value
        self.prev = prev
        self.next = next
        
class BrowserHistory(object):

    def __init__(self, homepage):
        """
        :type homepage: str
        """
        self.head = Node(homepage)
        self.current = self.head
        self.tail = self.head
        

    def visit(self, url):
        """
        :type url: str
        :rtype: None
        """
        new_node = Node(url)
        new_node.prev = self.current
        self.current.next = new_node
        self.tail = new_node
        self.current = new_node
        

    def back(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        for _ in range(steps):
            if self.current.prev != None:
                self.current = self.current.prev
            else:
                break
            
        return self.current.value
    def forward(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        for _ in range(steps):
            if self.current.next != None:
                self.current = self.current.next
            else:
                break
            
        return self.current.value
        


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)