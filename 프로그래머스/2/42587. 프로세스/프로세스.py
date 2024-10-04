from collections import deque

def solution(priorities, location):
    q = deque((p, i) for i, p in enumerate(priorities))
    iter_count = 0

    while q:
        cur = q.popleft()
        if any(cur[0] < other[0] for other in q):
            q.append(cur)
        else:
            iter_count += 1
            if cur[1] == location:
                return iter_count

    return iter_count
