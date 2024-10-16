# 맵의 상태 : maps, 0 : 벽, 1 : 벽 x 
# 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값
# 상대 팀 진영에 도착할 수 없을 때 : -1
# bfs
from collections import deque
def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    
    q = deque([(0, 0, 1)]) # row, col, path_length
    visited = set()
    visited.add((0, 0))
    
    while q:
        row, col, path_length = q.popleft()
        
        if row == n-1 and col == m-1:
            return path_length
        
        for dr, dc in directions:
            new_row = row + dr
            new_col = col + dc
            
            if 0 <= new_row < n and 0<= new_col < m and maps[new_row][new_col] == 1:
                if (new_row, new_col) not in visited:
                    q.append((new_row, new_col, path_length + 1))
                    visited.add((new_row, new_col))
        
    return -1