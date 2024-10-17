from collections import deque

# 좌표를 2배로 키우는 이유는 빈 칸을 제대로 처리하기 위함
def expand_coordinates(rectangles):
    expanded = []
    for x1, y1, x2, y2 in rectangles:
        expanded.append([x1*2, y1*2, x2*2, y2*2])
    return expanded

# 사각형의 외곽선을 표시하는 함수
def draw_boundary(graph, rectangles):
    for x1, y1, x2, y2 in rectangles:
        for i in range(x1, x2 + 1):
            graph[i][y1] = 1
            graph[i][y2] = 1
        for j in range(y1, y2 + 1):
            graph[x1][j] = 1
            graph[x2][j] = 1
    # 내부를 지우기
    for x1, y1, x2, y2 in rectangles:
        for i in range(x1 + 1, x2):
            for j in range(y1 + 1, y2):
                graph[i][j] = 0

    return graph

def bfs(graph, start, end):
    directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
    
    q = deque([(start[0], start[1], 0)]) 
    visited = set()
    visited.add((start[0], start[1]))
    
    while q:
        row, col, path_length = q.popleft()
        
        if row == end[0] and col == end[1]:
            return path_length
        
        for dr, dc in directions:
            new_row = row + dr
            new_col = col + dc
            
            if 0 <= new_row < 101 and 0<= new_col <101 and graph[new_row][new_col] == 1 and (new_row, new_col) not in visited:
                q.append((new_row, new_col, path_length + 1))
                visited.add((new_row, new_col))

        
def solution(rectangle, characterX, characterY, itemX, itemY):
    
    graph = [[0] * 101 for _ in range(101)]
    rectangles = expand_coordinates(rectangle)
    graph = draw_boundary(graph, rectangles)
    
    start = (characterX * 2, characterY * 2)
    end = (itemX * 2, itemY * 2)
    return bfs(graph, start, end)//2