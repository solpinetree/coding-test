# 모든 트럭이 다리를 건너려면 최소 몇 초 걸리는지
# bridge_length : 트럭이 최대 몇대 올라갈 수 있는지
# weight : 다리는 무게를 얼마나 견딜 수 있는지
# FIFO
from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = bridge_length
    
    bridge = deque()
    cur_weight = 0
    idx = 0
            
    while idx < len(truck_weights):
        if cur_weight + truck_weights[idx] <= weight:
            bridge.append(truck_weights[idx])
            cur_weight += truck_weights[idx]
            idx += 1
        else:
            bridge.append(0)

        if len(bridge) == bridge_length:
            cur_weight -= bridge.popleft()
            
        answer += 1
        
    # while bridge and max(bridge) != 0:
    #     print(bridge)
    #     answer += 1
    #     bridge.popleft()

    return answer