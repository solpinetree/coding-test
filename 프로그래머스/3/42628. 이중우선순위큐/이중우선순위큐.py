from heapq import heappush, heappop, heapify
from collections import defaultdict
def solution(operations):
    
    max_q = []
    min_q = []
    record = defaultdict(int)
    
    for operation in operations:
        command, num = operation.split()
        
        if command == 'I':
            heappush(min_q, int(num))
            heappush(max_q, -int(num))
            record[int(num)] += 1
        elif num == '1': # 최댓값 삭제
            while max_q:
                remove = heappop(max_q)
                if record[-remove] > 0:
                    record[-remove] -= 1
                    break
        else: # num == '-1', 최솟값 삭제 
            while min_q:
                remove = heappop(min_q)
                if record[remove] > 0:
                    record[remove] -= 1
                    break

    mx, mn = 0, 0
    
    while max_q:
            mx = heappop(max_q)
            if record[-mx] > 0:
                break
            mx = 0
    while min_q:
            mn = heappop(min_q)
            if record[mn] > 0:
                break
            mn = 0
            
    return [-mx, mn]