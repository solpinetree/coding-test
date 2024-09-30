from itertools import permutations

def solution(k, dungeons):
    answer = -1
    
    for i in permutations(dungeons, len(dungeons)):
        tmp_k = k
        tmp_answer = 0
        for 최소피로도, 소모피로도 in i:
            if tmp_k >= 최소피로도:
                tmp_k -= 소모피로도
                tmp_answer += 1
        
        answer = max(answer, tmp_answer)        
    
    return answer