from itertools import permutations
import math

def is_prime(number):
    if number <= 1:
        return False
    for i in range(2, int(math.sqrt(number)) + 1):
        if number%i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    unique_numbers = set()
    
    for i in range(1, len(numbers) + 1):
        for j in permutations(numbers, i):
            num = int(''.join(j))  # 튜플을 문자열로 변환 후, 정수로 변환
            unique_numbers.add(num)
    
    for number in unique_numbers:
        if is_prime(number):
            answer += 1
    
    return answer