# 대각선 방향으로 한 칸 오른쪽 or 왼쪽
# 거쳐간 숫자의 최댓값을 return -> dp 문제 
def solution(triangle):
    for i in range(1, len(triangle)):
        triangle[i][0] += triangle[i-1][0]
        triangle[i][-1] += triangle[i-1][-1]
        
    for i in range(2, len(triangle)):
        for j in range(1, i):
            triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
    
    
    
    return max(triangle[-1])