def solution(survey, choices):
    answer = ''
    
    score_mapping = {"RT":0, "CF":0, "JM":0, "AN":0}
    
    for type, choice in zip(survey, choices):
        if type not in score_mapping.keys():
            type = type[::-1]
            score_mapping[type] += choice - 4
        else:
            score_mapping[type] -= choice - 4
    
    for type in score_mapping.keys():
        if score_mapping[type] < 0:
            answer += type[1]
        else:
            answer += type[0]
            
    return answer
