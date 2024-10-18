# m x n 크기의 격자모양
# puddles : 물이 잠긴 지역의 좌표 담은 2차원 배열
# 오른쪽과 아래쪽으로만 움직여 집까지 갈 수 있는 경로의 개수를 1000000007로 나눈 나머지
# 점화식 :     grid[i][j] = grid[i-1][j] + grid[i][j-1]
# grid[1][1] = 1
def solution(m, n, puddles):
    grid = [[0] * (m+1) for _ in range(n+1)]
    grid[1][1] = 1
    
    for r, c in puddles:
        grid[c][r] = -1
    
    for row in range(1, n + 1):
        for col in range(1, m + 1):
            if grid[row][col] == -1:
                continue
            if grid[row-1][col] != -1:
                grid[row][col] += grid[row-1][col] 
            if grid[row][col-1] != -1:
                grid[row][col] += grid[row][col-1]
    
    return grid[n][m] % 1000000007
    