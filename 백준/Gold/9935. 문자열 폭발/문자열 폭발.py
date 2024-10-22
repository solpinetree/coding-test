import sys

s = sys.stdin.readline().strip()
bomb = sys.stdin.readline().strip()

bomb_len = len(bomb)
stack = []

for c in s:
    stack.append(c)
    
    # 스택의 마지막 부분이 폭탄 문자열과 동일한지 확인
    if ''.join(stack[-bomb_len:]) == bomb:
        # 폭탄 문자열을 스택에서 제거
        del stack[-bomb_len:]

# 결과 출력
result = ''.join(stack)
print(result if result else 'FRULA')
