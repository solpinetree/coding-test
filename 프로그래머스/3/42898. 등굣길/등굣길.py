# 격자의 크기 m, n
# 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles
# 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return
def solution(m, n, puddles):
    MOD = 1000000007
    
    # 격자 초기화
    grid = [[0] * (m + 1) for _ in range(n + 1)]
    
    # 시작점은 경로가 1개
    grid[1][1] = 1
    
    # 물에 잠긴 지역 표시
    for p in puddles:
        grid[p[1]][p[0]] = -1  # 물에 잠긴 지역 표시 (인덱스 맞추기)
    
    # 동적 계획법으로 경로 계산
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if grid[i][j] == -1:  # 물에 잠긴 곳은 건너뜀
                grid[i][j] = 0
            else:
                if i > 1:  # 위에서 오는 경로 추가
                    grid[i][j] += grid[i - 1][j]
                if j > 1:  # 왼쪽에서 오는 경로 추가
                    grid[i][j] += grid[i][j - 1]
                grid[i][j] %= MOD  # 큰 수를 나눠줌
    
    # 도착점에서의 경로 수 반환
    return grid[n][m]

        