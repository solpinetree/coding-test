from collections import deque

def can_transform(s1, s2):
    # 두 문자열이 하나의 문자만 다르면 True 반환
    return sum(c1 != c2 for c1, c2 in zip(s1, s2)) == 1

def solution(begin, target, words):
    if target not in words:
        return 0
    
    q = deque([(begin, 0)])
    visited = set()
    visited.add(begin)
    
    while q:
        current, count = q.popleft()
        
        if current == target:
            return count
            
        for word in words:
            if word not in visited and can_transform(current, word):
                visited.add(word)
                q.append((word, count+1))
    
    return 0
