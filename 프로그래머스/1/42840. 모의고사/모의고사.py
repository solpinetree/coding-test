def solution(answers):
    # 패턴을 선택하는 사람들의 답안을 미리 정의
    patterns = [
        [1, 2, 3, 4, 5], # 1번 수포자 패턴
        [2, 1, 2, 3, 2, 4, 2, 5],   # 2번 수포자 패턴
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]  # 3번 수포자 패턴
    ]
    
    scores = [0] * len(patterns) # 각 수포자의 점수를 저장할 리스트
    
    # 각 문제의 답안과 수포자들의 패턴을 비교하여 점수를 계산
    for idx, answer in enumerate(answers):
        for i, pattern in enumerate(patterns):
            if pattern[idx % len(pattern)] == answer:
                scores[i] += 1
    
    # 가장 높은 점수를 받은 수포자를 추출
    max_score = max(scores)
    
    answer = [i + 1 for i, score in enumerate(scores) if score == max_score]
    
    return answer
