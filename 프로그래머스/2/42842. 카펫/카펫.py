# brown: 갈색 격자의 수 
# yellow: 노란색 격자의 수

import math

def solution(brown, yellow):
    for i in range(1, int(math.sqrt(yellow))+1):
        
        if yellow % i == 0:
            y_w = yellow//i
            y_h = i
            b_w = y_w + 2
            b_h = y_h + 2
            
            if b_w*b_h - y_w*y_h == brown:
                return [b_w, b_h]