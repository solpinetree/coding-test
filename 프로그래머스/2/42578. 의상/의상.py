from collections import defaultdict

def solution(clothes):
    # 카테고리별로 의상 개수를 저장하는 딕셔너리
    category_dict = defaultdict(int)
    
    # 각 의상 종류별로 카테고리 내 의상 개수를 셈
    for _, category in clothes:
        category_dict[category] += 1
    
    answer = 1
    
    # 각 카테고리에서 선택할 수 있는 경우의 수는 (의상 개수 + 1)입니다. (선택하지 않는 경우 포함)
    for category in category_dict:
        answer *= (category_dict[category] + 1)
    
    # 아무것도 입지 않는 경우를 제외해야 하므로 1을 뺌
    return answer - 1
