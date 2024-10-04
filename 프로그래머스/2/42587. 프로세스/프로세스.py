from collections import deque

def solution(priorities, location):
    answer = 0
    
    q = deque()
    process = deque()
    
    for i, p in enumerate(priorities):
        q.append(p)
        if i == location:
            process.append(1)
        else:
            process.append(0)

    print(q)
    max_p = max(q)
    iter = 1
    while q:
        max_p = max(q)
        tmp = q.popleft()
        cur_process = process.popleft()
        if tmp < max_p:
            q.append(tmp)
            process.append(cur_process)
            continue
            
        if cur_process == 1:
            return iter
        
        iter += 1
    
    return iter