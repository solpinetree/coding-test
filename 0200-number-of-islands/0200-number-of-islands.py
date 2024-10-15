# '1' : land
# '0' : water
# return the number of islands
# island : surrounded by water, connecting adjacent lands horizontally or vertically
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        visited = set()
        
        def dfs(graph, cur_v):
            if cur_v in visited:
                return

            visited.add(cur_v)

            if cur_v[0] > 0 and graph[cur_v[0]-1][cur_v[1]] == '1':
                dfs(graph, (cur_v[0]-1, cur_v[1]))
            if cur_v[0] < len(graph) - 1 and graph[cur_v[0]+1][cur_v[1]] == '1':
                dfs(graph, (cur_v[0]+1, cur_v[1]))
            if cur_v[1] > 0 and graph[cur_v[0]][cur_v[1]-1] == '1':
                dfs(graph, (cur_v[0], cur_v[1]-1))
            if cur_v[1] < len(graph[0]) - 1 and graph[cur_v[0]][cur_v[1]+1] == '1':
                dfs(graph, (cur_v[0], cur_v[1]+1))
        
        answer = 0
        
        for row in range(len(grid)):
            for col in range(len(grid[row])):
                if grid[row][col] == '1' and (row, col) not in visited:
                    dfs(grid, (row, col))
                    answer +=1
        
        return answer