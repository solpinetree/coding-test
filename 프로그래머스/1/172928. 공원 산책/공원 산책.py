def solution(park, routes):
    current = []

    route_dict = {
        "W": (0, -1),
        "E": (0, 1),
        "N": (-1, 0),
        "S": (1, 0)
    }
    
    for h in range(0, len(park)):
        for w in range(0, len(park[h])):
            if park[h][w] == 'S':
                current = [h, w]
                break
    
    H = len(park)
    W = len(park[0])
    
    for route in routes:
        op = route.split()[0]
        n = int(route.split()[1])
        temp = current
        
        while n > 0:
            temp = [temp[0] + route_dict[op][0], temp[1] + route_dict[op][1]]
            n -= 1
            
            if not (temp[0] >=0 and temp[1] >=0 and temp[0] < H and temp[1] < W and park[temp[0]][temp[1]] != 'X'):
                temp = current
                break
        
        current = [temp[0], temp[1]]  
    
    return current