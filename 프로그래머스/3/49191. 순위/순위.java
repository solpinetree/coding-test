import java.util.*;
class Solution {
    private static HashMap<Integer, List<Integer>> win = new HashMap<>();
    private static HashMap<Integer, List<Integer>> lose = new HashMap<>();
    private static int N;
      private int winDfs(int cur) {
        int count = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> wins = win.getOrDefault(cur, new ArrayList<>());
        boolean[] visited = new boolean[N+1];
        visited[cur] = true;
        for(int l : wins) stack.add(l);
        
        while(!stack.isEmpty()) {
            int next = stack.poll(); 
            if(!visited[next]) {
                visited[next] = true;
                count++;
                for(int nextL : win.getOrDefault(next, new ArrayList<>())) {
                    stack.add(nextL);
                }
            }
        }
        
        return count;
    }
    
    private int loseDfs(int cur) {
        int count = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> loses = lose.getOrDefault(cur, new ArrayList<>());
        boolean[] visited = new boolean[N+1];
        visited[cur] = true;
        for(int l : loses) stack.add(l);
        
        while(!stack.isEmpty()) {
            int next = stack.poll(); 
            if(!visited[next]) {
                visited[next] = true;
                count++;
                for(int nextL : lose.getOrDefault(next, new ArrayList<>())) {
                    stack.add(nextL);
                }
            }
        }
        
        return count;
    }
    public int solution(int n, int[][] results) {
        int answer = 0;
        N = n;
        
        for(int[] result : results) {
            win.putIfAbsent(result[0], new ArrayList<>());
            lose.putIfAbsent(result[1], new ArrayList<>());
            win.get(result[0]).add(result[1]);
            lose.get(result[1]).add(result[0]);
        }
        
        for(int i = 1; i <= n; i++) {
            if(winDfs(i) + loseDfs(i) == n - 1) answer++;
        }
        
        return answer;
    }
}