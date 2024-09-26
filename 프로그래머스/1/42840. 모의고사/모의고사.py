def solution(answers):
    choices = {
        0 : [1, 2, 3, 4, 5], 
        1 : [2, 1, 2, 3, 2, 4, 2, 5],
        2 : [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    }
    
    scores = [0, 0, 0]
    
    for idx, answer in enumerate(answers):
        for i in range(len(scores)):
            if choices[i][idx%len(choices[i])] == answer:
                scores[i] += 1
    
    answer = [1]
    
    for idx in range(1, len(scores)):
        if scores[answer[-1]-1] < scores[idx]:
            answer = [idx+1]
        elif scores[answer[-1]-1] == scores[idx]:
            answer.append(idx+1)
    
    return answer