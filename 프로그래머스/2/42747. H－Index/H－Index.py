# 이 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations
# 이 과학자의 H-index를 return
def solution(citations):
    
    citations = sorted(citations, reverse=True)
    for i, v in enumerate(citations):
        # v번 이상 인용된 논문이 i + 1편 이상
        if v == i + 1:
            return v
        if v > i + 1:
            continue
        if v < i + 1:
            return i 
                
    return len(citations)