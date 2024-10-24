from heapq import heappush, heappop
import sys

def solution():
    
    N = sys.stdin.readline().strip()
    min_q = []
    
    for _ in range(int(N)):
        # x가 0이라면 배열에서 가장 작은 값을 출력 -> 배열에서 제거
        # 배열이 비어 있는 경우에는 0을 출력
        
        x = sys.stdin.readline().strip()
        x = int(x)
        
        if x == 0:
            if not min_q:
                print(0)
            else:
                print(heappop(min_q))
        else:
            heappush(min_q, x)
            
    
solution()