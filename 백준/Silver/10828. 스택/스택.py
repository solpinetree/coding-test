import sys

N = int(sys.stdin.readline().strip())
stack = []

# N개의 명령어를 차례로 처리
for i in range(N):
    
    input_ = sys.stdin.readline().strip()
    command = input_.split()[0]
    
    if command == 'push':
        stack.append(input_.split()[1])
    elif command == 'pop':
        print(stack.pop() if len(stack) > 0 else -1)
    elif command == 'size':
        print(len(stack))
    elif command == 'empty':
        print(1 if not stack else 0)
    elif command == 'top':
        print(stack[-1] if len(stack) > 0 else -1)