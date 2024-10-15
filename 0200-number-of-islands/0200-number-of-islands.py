class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # 상하좌우 방향 벡터

        def dfs(row, col):
            stack = [(row, col)]
            while stack:
                cur_row, cur_col = stack.pop()
                if grid[cur_row][cur_col] == '0':
                    continue
                
                grid[cur_row][cur_col] = '0'  # 방문한 노드를 '0'으로 변경하여 방문 표시
                
                for dr, dc in directions:
                    new_row, new_col = cur_row + dr, cur_col + dc
                    if 0 <= new_row < len(grid) and 0 <= new_col < len(grid[0]) and grid[new_row][new_col] == '1':
                        stack.append((new_row, new_col))
        
        answer = 0
        
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == '1':
                    dfs(row, col)
                    answer += 1
        
        return answer
