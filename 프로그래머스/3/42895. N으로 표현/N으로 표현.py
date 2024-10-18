# 최솟값 -> dp
# 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현할 수 있는 방법 중
# N 사용횟수의 최솟값을 return 
def solution(N, number):
    
    memo = {}
    memo[1] = [N]
    
    if N == number:
        return 1
    
    for i in range(2, 9):
        memo[i] = [int(str(N) * i)]
        
        for j in range(1, i):
            for k in memo[j]:
                for l in memo[i-j]:
                    memo[i].append(k+l)
                    memo[i].append(k-l)
                    memo[i].append(k*l)
                    if l != 0:
                        memo[i].append(k//l)
        
        if number in memo[i]:
            return i
    
    return -1
