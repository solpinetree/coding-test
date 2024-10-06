from collections import deque

def solution(bridge_length, weight, truck_weights):
    # 현재 다리를 건너고 있는 트럭들을 나타내는 큐 (트럭 무게 + 다리 위에 있는 시간)
    bridge = deque([0] * bridge_length)
    cur_weight = 0  # 현재 다리 위에 있는 트럭의 총 무게
    time = 0  # 경과 시간

    for truck in truck_weights:
        while True:
            # 1초 경과, 다리 위에 있는 가장 앞 트럭이 다리를 빠져나옴
            time += 1
            cur_weight -= bridge.popleft()

            # 현재 트럭이 다리 위에 오를 수 있는지 확인
            if cur_weight + truck <= weight:
                bridge.append(truck)
                cur_weight += truck
                break
            else:
                # 무게를 초과하면 트럭이 다리에 오르지 않고 다리에서 0만 추가
                bridge.append(0)

    # 마지막 트럭이 다리를 완전히 건너기까지의 시간 추가
    time += bridge_length

    return time
