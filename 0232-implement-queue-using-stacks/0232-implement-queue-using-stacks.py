class MyQueue(object):

    def __init__(self):
        self.input_stack = []  # 입력 스택
        self.output_stack = []  # 출력 스택

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.input_stack.append(x)

    def pop(self):
        """
        :rtype: int
        """
        self._move_input_to_output()
        return self.output_stack.pop()

    def peek(self):
        """
        :rtype: int
        """
        self._move_input_to_output()
        return self.output_stack[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return not self.input_stack and not self.output_stack

    def _move_input_to_output(self):
        """
        입력 스택의 요소를 출력 스택으로 옮김으로써 큐의 순서를 유지
        """
        if not self.output_stack:  # 출력 스택이 비어 있을 때만 이동
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())
