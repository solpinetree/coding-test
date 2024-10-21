import sys

N = int(sys.stdin.readline().strip())
Q = []

# N개의 명령어를 차례로 처리
for i in range(N):
    
    input_ = sys.stdin.readline().strip()
    command = input_.split()[0]
    
    if command == 'push':
        Q = [input_.split()[1]] + Q[:]
    elif command == 'pop':
        print(Q.pop() if len(Q) > 0 else -1)
    elif command == 'size':
        print(len(Q))
    elif command == 'empty':
        print(1 if not Q else 0)
    elif command == 'front':
        print(Q[-1] if len(Q) > 0 else -1)
    elif command == 'back':
        print(Q[0] if len(Q) > 0 else -1)
