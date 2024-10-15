from collections import deque
class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        # 8-direction
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1), (1, 1), (1, -1), (-1, 1), (-1, -1)]
        n = len(grid)
        
        if grid[0][0] == 1 or grid[n-1][n-1] == 1:
            return -1
        
        q = deque([(0, 0, 1)]) # row, col, path_length
        visited = set()
        visited.add((0, 0))
        
        while q:
            row, col, path_length = q.popleft()
            
            if row == n-1 and col == n-1:
                return path_length

            for dr, dc in directions:
                new_row, new_col = row + dr, col + dc
                if 0 <= new_row < n and 0 <= new_col < n and grid[new_row][new_col] == 0 and (new_row, new_col) not in visited:
                    # 여기서 visited 를 해줘야 더 긴 경로를 돌지 않음
                    visited.add((new_row, new_col))
                    q.append((new_row, new_col, path_length + 1))

        return -1 