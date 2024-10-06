# 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses
# 각 작업의 개발 속도가 적힌 정수 배열 speeds
# 각 배포마다 몇 개의 기능이 배포되는지
from collections import deque
import math 

def solution(progresses, speeds):
    answer = []
    q = deque()
    a = 1
    tmp = 0
    
    for i, p in enumerate(progresses):
        days = math.ceil((100 - p)/speeds[i])
        if not q:
            q.append(days)
            a = 1
        else:
            tmp = max(tmp, q.popleft())
            if tmp >= days:
                a += 1
            else:
                answer.append(a)
                a = 1
            q.append(days)
    answer.append(a)
    return answer