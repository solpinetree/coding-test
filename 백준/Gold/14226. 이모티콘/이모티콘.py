import sys
from collections import deque

def solution():
    
    # S : 이모티콘 S개
    S = int(sys.stdin.readline().strip())
    
    # 3가지 연산만 사용해서 이모티콘 S개를 만드는 데 걸리는 시간의 최솟값(bfs)
    # 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장(이전에 있던 내용은 덮어쓰기 됨)
    # 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기(클립보드가 비어 있으면 안됨)
    # 3. 화면에 있는 이모티콘 중 하나를 삭제
    
    def bfs():
        q = deque([(1, 0, 0)]) # emoji, clipboard, time
        visited = set([(1,0)])
        while q:
            emoji, clipboard, time = q.popleft()
            if emoji == S:
                print(time)
                return
            
            if (emoji, emoji) not in visited:
                q.append((emoji, emoji, time + 1))
                visited.add((emoji, emoji))
            if clipboard != 0 and 0 < emoji + clipboard and (emoji + clipboard, clipboard) not in visited:
                q.append((emoji + clipboard, clipboard, time + 1))
                visited.add((emoji + clipboard, clipboard))
            if emoji - 1 > 0 and (emoji-1, clipboard) not in visited:
                q.append((emoji-1, clipboard, time + 1))
                visited.add((emoji-1, clipboard))
    
    bfs()

solution()
