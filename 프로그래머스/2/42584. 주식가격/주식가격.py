# 초 단위로 기록된 주식 가격이 담긴 배열 : prices
# 가격이 떨어지지 않은 기간은 몇 초인지
# LIFO - stack
# [1, 2, 3, 4, 2, 3] -> [5, 4, 2, 2, 1, 0]

def solution(prices):
    n = len(prices)
    answer = [0] * n
    stack = []
    
    for i in range(n):
        # 현재 가격이 이전 스택에 있는 가격보다 낮다면
        while stack and prices[i] < prices[stack[-1]]:
            prev_index = stack.pop()
            answer[prev_index] = i - prev_index
        stack.append(i)
        
    # 스택에 남아있는 인덱스들은 끝까지 가격이 떨어지지 않은 경우임
    while stack:
        prev_index = stack.pop()
        answer[prev_index] = n - 1 - prev_index
            
    return answer