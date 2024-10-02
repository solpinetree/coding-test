def solution(arr):
    answer = []
    if len(arr) == 0:
        return answer
    
    last = arr[0]
    answer.append(last)
    
    for i in range(1, len(arr)):
        if last == arr[i]:
            continue
        else:
            answer.append(arr[i])
            last = arr[i]
        
    return answer