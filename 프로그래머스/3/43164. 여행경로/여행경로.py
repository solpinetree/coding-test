from collections import defaultdict

def solution(tickets):
    routes = defaultdict(list)
    
    # 티켓 정보를 통해 그래프 설정
    for f, t in tickets:
        routes[f].append(t)
        
    # 목적지 리스트를 사전순으로 정렬
    for key in routes:
        routes[key].sort(reverse=True) # pop() 했을 때 알파벳 순서이도록
    
    # 경로를 저장할 stack 
    path = []
    
    # DFS 탐색 모든 경로 탐색이므로 
    def dfs(airport):
        while routes[airport]:
            dfs(routes[airport].pop())
        path.append(airport)
        
    dfs('ICN')
    
    # 후위 순회이므로 역순
    return path[::-1]