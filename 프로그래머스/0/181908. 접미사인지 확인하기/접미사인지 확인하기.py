def solution(my_string, is_suffix):
    answer = 0
    
    for i in range(0, len(my_string)):
        if is_suffix == my_string[i:]: 
            answer = 1
    
    return answer