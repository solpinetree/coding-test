# 모든 음식의 스코빌 지수를 K 이상으로 만들기위해 섞어야 하는 최소 횟수
from heapq import heapify, heappop, heappush
def solution(s, K):
    heapify(s)
    mild = heappop(s)
    cnt = 0
    
    while mild < K:
        if len(s) < 1:
            return -1
        
        new = mild + heappop(s) * 2
        heappush(s, new)
        
        mild = heappop(s)
        cnt += 1
    
    return cnt