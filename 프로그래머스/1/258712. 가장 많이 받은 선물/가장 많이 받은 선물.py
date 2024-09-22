# 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 
# 선물 지수 = 자신이 친구들에게 준 선물의 수 - 받은 선물의 수
# 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받음
# 주고받은 기록이 하나도 없거나 같다면, 선물 지수가 더 큰 사람이 선물 받음
def solution(friends, gifts):
    # 각 친구가 준 선물과 받은 선물의 수를 기록하는 딕셔러니
    give = {friend: 0 for friend in friends}
    got = {friend: 0 for friend in friends}
    gift_dict = {friend: [] for friend in friends}
    
    # 선물 정보를 바탕으로 누가 누구에게 선물을 주었는지 기록
    for gift in gifts:
        f, t = gift.split()
        gift_dict[f].append(t)
        give[f] += 1
        got[t] += 1
        
    # 선물 지수 계산 (준 선물 - 받은 선물)
    gift_degree = {friend: give[friend] - got[friend] for friend in friends}
    
    answer = 0
    
    for f in friends:
        temp = 0
        
        for t in friends:
            if f == t:
                continue
            # 서로 주고받은 선물이 같은 경우
            if gift_dict[f].count(t) == gift_dict[t].count(f):
                if gift_degree[f] > gift_degree[t]:
                    temp += 1
            # 한쪽이 더 많은 선물을 준 경우
            elif gift_dict[f].count(t) > gift_dict[t].count(f):
                temp += 1
        
        # 가장 높은 값을 answer에 저장
        answer = max(answer, temp)
                
    return answer