def solution(N, number):
    # N을 1번부터 8번까지 사용해서 나올 수 있는 모든 값들을 저장하는 리스트
    dp = [set() for _ in range(9)]
    
    # N을 i번 사용해서 나오는 숫자들을 저장
    for i in range(1, 9):
        # N을 i번 연속해서 쓴 수 (ex. N=5이면, 5, 55, 555, ...)
        dp[i].add(int(str(N) * i))
        
        # N을 j번 사용한 결과와 N을 i-j번 사용한 결과들을 사칙연산
        for j in range(1, i):
            for x in dp[j]:
                for y in dp[i - j]:
                    dp[i].add(x + y)  # 더하기
                    dp[i].add(x - y)  # 빼기
                    dp[i].add(x * y)  # 곱하기
                    if y != 0:
                        dp[i].add(x // y)  # 나누기
                    
        # 만약 dp[i]에 목표 숫자 number가 있으면 i를 반환
        if number in dp[i]:
            return i
    
    # 8번을 넘어도 찾지 못하면 -1을 반환
    return -1
