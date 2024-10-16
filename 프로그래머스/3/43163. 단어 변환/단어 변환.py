from collections import deque
def solution(begin, target, words):
    answer = 0
    n = len(begin)
    
    if target not in words:
        return 0
    
    q = deque([(begin, 0)])
    visited = set()
    visited.add(begin)
    
    # hit -> hut -> dut -> gut -> got -> gog -> cog
    # 
    while q:
        s, cnt = q.popleft()
        
        if s == target:
            return cnt
            
        for idx in range(n):
            for word in words:
                if s[idx] != word[idx]:
                    new_s = s[:idx] + word[idx]
                    if idx < n - 1:
                        new_s += s[idx+1:]
                    if new_s in words and new_s not in visited:
                        q.append((new_s, cnt + 1))
                        visited.add(new_s)
    
    return 0