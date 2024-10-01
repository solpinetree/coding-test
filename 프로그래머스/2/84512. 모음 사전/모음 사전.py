def solution(word):
    # 모음 리스트 정의
    vowels = ['A', 'E', 'I', 'O', 'U']
    
    # 단어의 최대 길이 정의
    max_len = 5

    # 가능한 모든 단어 조합을 저장할 리스트
    words = []

    # 재귀 함수를 통해 모든 가능한 조합 생성
    def generate(current):
        if len(current) > max_len:
            return
        if current:
            words.append(current)
        for vowel in vowels:
            generate(current + vowel)

    # 빈 문자열부터 조합 생성 시작
    generate("")

    # 생성된 단어들을 정렬
    words.sort()

    # 주어진 단어의 위치를 찾아 반환 (인덱스는 0부터 시작하므로 +1)
    return words.index(word) + 1