def solution(survey, choices):
    answer = ''
    
    # choices : [i번째 캐릭터, 점수]
    scores = {
        1: [0, 3],
        2: [0, 2],
        3: [0, 1],
        4: [0, 0],
        5: [1, 1],
        6: [1, 2],
        7: [1, 3]
    }
    
    types = "RTCFJMAN"
    types_score = {type: 0 for type in types}
    
    for i in range(len(survey)):
        sur_type = survey[i] 
        choice = choices[i]
        
        types_score[sur_type[scores[choice][0]]] += scores[choice][1] 
        
    for i in range(0, len(types) - 1, 2):
        if types_score[types[i]] < types_score[types[i+1]]:
            answer += types[i+1]
        else:
            answer += types[i]
    
    return answer