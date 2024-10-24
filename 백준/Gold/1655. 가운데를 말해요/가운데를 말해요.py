from heapq import heappush, heappop
import sys

def solution():
    
    N = sys.stdin.readline().strip()
    median = 0
    min_heap = []
    max_heap = []
    
    for i in range(int(N)):
        # 백준이가 말한 수 중에서 중간값을 말해야 함
        # 백준이가 외친 수의 개수 = 짝수개 -> 중간에 있는 두 수 중에서 작은 수를 말해야함
        
        x = sys.stdin.readline().strip()
        x = int(x) 
        
        if i == 0:
            median = x
            print(median)
            continue
        
        if x < median:
            heappush(min_heap, -x)
        else:
            heappush(max_heap, x)

        if len(min_heap) > len(max_heap):
            heappush(max_heap, median)
            median = -heappop(min_heap)
        elif len(max_heap) - len(min_heap) >= 2:
            heappush(min_heap, -median)
            median = heappop(max_heap)
            
        print(median)
        
solution()
