import java.util.*;
// ** 다리에 완전히 오르지 않은 트럭의 무게는 무시
// bridge_length : 다리에 올라갈 수 있는 트럭의 최대 수
// weight : 견딜 수 있는 무게(weight 이하까지)
// truck_weights : 트럭 별 무게
// return : 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return
class Solution {
    class Node {
        final int weight;
        final int time;
        public Node(int weight, int time) {
            this.weight = weight; this.time = time;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int total = truck_weights[0];
        int time = 1;
        for(int i = 0; i < bridge_length - 1; i++) q.addLast(0);
        q.addLast(truck_weights[0]);
        int idx = 1;
        while(!q.isEmpty()) {
            time++;
            total -= q.pollFirst();
            if(idx < truck_weights.length) {
                if(total + truck_weights[idx] <= weight) {
                    total += truck_weights[idx];
                    q.addLast(truck_weights[idx]);
                    idx++;
                } else {
                    q.addLast(0);
                }
            }
        }
        return time;
    }
}