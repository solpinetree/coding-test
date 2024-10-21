# progresses : 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
# speeds : 각 작업의 개발 속도가 적힌 정수 배열
# return : 각 배포마다 몇 개의 기능이 배포되는지
# 배포는 하루에 한 번만. 하루의 끝에 이루어짐.
import math 

def solution(progresses, speeds):
    days = []
    answer = []
    
    for p, s in zip(progresses, speeds):
        days.append(math.ceil((100-p)/s))
    
    deploy = days[0]
    deploy_n = 0
    
    for day in days:
        if day <= deploy:
            deploy_n += 1
        else:
            answer.append(deploy_n)
            deploy_n = 1
            deploy = day
    
    answer.append(deploy_n)
    return answer