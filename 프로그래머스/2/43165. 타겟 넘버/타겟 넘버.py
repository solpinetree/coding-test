# 사용할 수 있는 숫자가 담긴 배열 : numbers
# 더하거나 빼서 타겟 넘버로 
def solution(numbers, target):
    n = len(numbers)
    
    def dfs(idx, total = 0):
        if idx == n:
            if total == target:
                return 1
            else:
                return 0
        
        return dfs(idx + 1, total + numbers[idx]) + dfs(idx + 1, total -numbers[idx])
    return dfs(0)