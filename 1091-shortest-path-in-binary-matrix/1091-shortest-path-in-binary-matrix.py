from collections import deque
class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        # 가능한 8개의 방향(상하좌우, 대각선)
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]
        answer = 100 * 100
        n = len(grid)
        
        # 시작점이나 끝점이 막혀있으면 바로 불가능한 경로로 판단
        if grid[0][0] == 1 or grid[n-1][n-1] == 1:
            return -1
        
        # BFS 초기화
        queue = deque([(0, 0, 1)]) # (row, col, path_length)
        visited = set()
        visited.add((0, 0))
        
        while queue:
            row, col, path_length = queue.popleft()
            
            # 도착점에 도달하면 경로 길이를 반환
            if row == n-1 and col == n-1:
                return path_length
            
            # 8개의 방향으로 탐색
            for dr, dc in directions:
                new_row, new_col = row + dr, col + dc
                
                if 0 <= new_row < n and 0 <= new_col < n and grid[new_row][new_col] == 0 and (new_row, new_col) not in visited:
                    
                    visited.add((new_row, new_col))
                    queue.append((new_row, new_col, path_length + 1))
                    
        return -1