# 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players
# 해설진이 부른 이름을 담은 문자열 배열 callings
# 1등부터 등수 순서대로 선수들의 이름을 배열에 담아 return 
def solution(players, callings):
    rank = {}
    
    for idx, player in enumerate(players):
        rank[player] = idx
    
    for c in callings:
        index = rank[c]
        rank[c] = index - 1
        rank[players[index-1]] = index
        players[index], players[index - 1] = players[index - 1], players[index]
    return players