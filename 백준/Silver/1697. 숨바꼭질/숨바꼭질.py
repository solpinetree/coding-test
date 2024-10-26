import sys
from collections import deque

def solution():
    
    # N : 수빈이가 있는 위치(0 ~ 100000), K : 동생이 있는 위치(0 ~ 100000)
    N, K = sys.stdin.readline().strip().split()
    N = int(N)
    K = int(K) 
    
    # 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지
    def bfs():
        q = deque([(N, 0)]) # position, time
        visited = set([N])
        while q:
            position, time = q.popleft()
            
            if position == K:
                return time
            
            for next_position in (position + 1, position - 1, position * 2):
                if 0 <= next_position <= 100000 and next_position not in visited:
                    visited.add(next_position)
                    q.append((next_position, time + 1))
    
    return bfs()

print(solution())
