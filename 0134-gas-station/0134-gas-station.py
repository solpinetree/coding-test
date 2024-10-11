class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        if sum(gas) < sum(cost):
            return -1

        start = 0
        tank = 0
        
        for i in range(len(gas)):
            tank += gas[i] - cost[i]
            if tank < 0:
                # 현재까지의 경로로는 순회할 수 없음, 다음 주유소를 출발점으로 설정
                start = i + 1
                tank = 0
        
        return start
