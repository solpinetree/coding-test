# n : 처음 표의 행 개수
# k : 처음에 선택된 행의 위치
# cmd : 수행한 명령어들이 담긴 문자열 배열
# 모든 명령어를 수행한 후 표의 상태와 처음 주어진 표의 상태를 비교하여 삭제되지 않은 행 O, X로 표시하여 리턴
def solution(n, k, cmd):
    answer = ['O'] * n
    prev = {i: i-1 for i in range(n)}
    next = {i: i+1 for i in range(n)}
    cancels = []
    
    for c in cmd:
        if c[0] == "U":
            cnt = int(c.split()[1])
            for _ in range(cnt):
                k = prev[k]
        elif c[0] == 'D':
            cnt = int(c.split()[1])
            for _ in range(cnt):
                k = next[k]
        elif c[0] == 'C':
            answer[k] = 'X'
            cancels.append((k, prev[k], next[k])) # 현재 행과 이전/다음 정보를 저장
            
            # 이전과 다음을 서로 연결하여 삭제된 행을 건너뜀
            if prev[k] != -1:
                next[prev[k]] = next[k]
            if next[k] != n:
                prev[next[k]] = prev[k]
                
            # 마지막 행이면 커서를 위로, 그렇지 않으면 아래로 이동
            k = next[k] if next[k] != n else prev[k]
        elif c[0] == 'Z':
            idx, p, n_ = cancels.pop()
            answer[idx] = 'O'
            
            # 복구된 행을 다시 이전과 다음에 연결
            # p가 삭제된 상태일 경우, p의 값이 존재하는 첫번재 행을 찾음
            while p != -1 and answer[p] == 'X':
                p = prev[p]
            if p != -1:
                next[p] = idx
            
            # n_ 이 삭제된 상태일 경우, n_의 값이 존재하는 첫번째 행을 찾음
            while n_ != n and answer[n_] == 'X':
                n_ = next[n_]
            if n_ != n:
                prev[n_] = idx
                
            prev[idx] = p
            next[idx] = n_
                
    return ''.join(answer)