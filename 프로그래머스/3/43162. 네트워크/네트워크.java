import java.util.*;
class Solution {
    // n : 컴퓨터의 개수
    // computers: 연결에 대한 정보가 담긴 배열
    // return : 네트워크 개수
    
    // 모두 -> dfs(stack)
    
    private static HashSet<Integer> visited = new HashSet<>();
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for (int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int cur, int[][] computers) {
        visited.add(cur);
        
        for(int i=0;i<computers[cur].length;i++) {
            if(computers[cur][i] == 1 && !visited.contains(i)) {
                dfs(i, computers);
            }
        }
    }
}