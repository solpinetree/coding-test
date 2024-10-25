import sys
from collections import defaultdict, deque

def solution():
    
    # N : 정점의 개수, M : 간선의 개수, V : 탐색을 시작할 정점의 번호
    N, M, V = sys.stdin.readline().strip().split()

    graph = defaultdict(list)

    for _ in range(int(M)):
        V1, V2 = sys.stdin.readline().strip().split()
        graph[int(V1)].append(int(V2))  # 간선은 양방향
        graph[int(V2)].append(int(V1))
        
    graph = {key: sorted(value) for key, value in graph.items()}  
    
    def bfs(graph, start_v):
        visited = [start_v]
        queue = deque([start_v])
        while queue:
            cur_v = queue.popleft()
            if cur_v in graph:
                for v in graph[cur_v]:
                    if v not in visited:
                        queue.append(v)
                        visited.append(v)
        return visited
    
    def dfs(graph, cur_v, visited=[]):
        visited.append(cur_v)
        if cur_v in graph:
            for v in graph[cur_v]:
                if v not in visited:
                    visited = dfs(graph, v, visited)
        return visited
    
    print(' '.join(map(str, dfs(graph, int(V)))))
    print(' '.join(map(str, bfs(graph, int(V)))))
    
solution()
