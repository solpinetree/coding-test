import sys

N = int(sys.stdin.readline().strip())
inputs = []

# N개의 명령어를 차례로 처리
for i in range(N):
    inputs.append(sys.stdin.readline().strip())
    
for s in inputs:
    stack = []
    for c in s:
        if c == '(':
            stack.append(c)
        elif c == ')':
            if not stack or stack.pop() != '(':
                print('NO')
                break
    else:
        print('NO' if stack else 'YES')