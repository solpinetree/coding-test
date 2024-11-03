// n 개의 노드가 있는 그래프 - 1 ~ n
// 1번 노드에서 가장 멀리 떨어진 노드의 갯수 - 최단 경로로 이동했을 때 간선의 개수가 가장 많은 노드
// 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열
// 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return
// 다익스트라 알고리즘
import java.util.*;
class Solution {
    private static int[] prev;
    private static int[] cost;
    private static PriorityQueue<Node> pq = new PriorityQueue<>(
    (o1, o2) -> o1.cost - o2.cost);
    private static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    class Node {
        int node, cost;
        Node(int node, int cost) {
            this.node = node; this.cost = cost;
        }
    }
    public int solution(int n, int[][] edge) {
        prev = new int[n+1];
        cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        int max = 0;
        cost[1] = 0;
        
        for (int[] e : edge) {
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        pq.add(new Node(1, 0));
        while(!pq.isEmpty()) {
            Node v = pq.poll();
            for (int adj : graph.getOrDefault(v.node, List.of())) {
                if (cost[adj] > cost[v.node] + 1) {
                    cost[adj] = cost[v.node] + 1; 
                    prev[adj] = v.node;
                    pq.add(new Node(adj, cost[adj]));
                    if(cost[adj] > max) max = cost[adj];
                }
            }
        }
        
        int answer = 0;
        
        for(int c : cost) {            
            if (c == max)  answer++;
        }
        
        return max == 0 ? 0 : answer;
    }
}