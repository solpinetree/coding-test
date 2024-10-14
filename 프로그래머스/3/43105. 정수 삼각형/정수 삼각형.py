# [0]
# [0, 1]
# [0, 1, 2]
# [0, 1, 2, 3]
# [0, 1, 2, 3, 4]
def solution(triangle):
    answer = triangle[0][0]
    
    for row in range(1, len(triangle)):
        for col in range(row + 1):
            if col == 0:
                triangle[row][col] += triangle[row-1][col]
            elif col == row:
                triangle[row][col] += triangle[row-1][col-1]
            else:
                triangle[row][col] += max(triangle[row-1][col-1], triangle[row-1][col])
    
    return max(triangle[len(triangle)-1])