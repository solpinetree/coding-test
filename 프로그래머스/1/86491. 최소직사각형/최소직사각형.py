# 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes 
def solution(sizes):
    w = []
    h = []
    
    for size in sizes:
        w.append(size[0])
        h.append(size[1])
    
    answer = max(w) * max(h)
    
    for _ in range(len(sizes)):
        w_max_idx = w.index(max(w))
        h_max_idx = h.index(max(h))

        answer = min(max(w)*max(h), answer)

        w[h_max_idx], h[h_max_idx] = h[h_max_idx], w[h_max_idx]
    
    return answer
    
    
    return answer