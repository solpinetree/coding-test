// 벽으로 된 칸 지나갈 수 O
// 통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있음
// 레버 또한 통로들 중 한 칸에 있음
// 먼저 레버가 있는 칸으로 이동 -> 미로를 빠져나가는 문이 있는 칸으로 이동
// 레버가 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있음
// 미로에서 한 칸을 이동 = 1초, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간
// maps : 미로, return : 미로를 탈출하는데 필요한 최소 시간
// 탈출할 수 없다면 -1
import java.util.*;
class Solution {
    class Node {
        int row, col, path;
        Node(int row, int col, int path) {
            this.row = row;
            this.col = col;
            this.path = path;
        }
    }
    
    private static String[] map;
    private static int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int N;
    private static int M;
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        int[] s = new int[2];
        int[] l = new int[2]; 
        int[] e = new int[2];
        map = maps;
        
        // 1. 일단 입구와 레버 위치를 찾음
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++){
                if (maps[i].charAt(j) == 'S') s = new int[]{i, j};
                if (maps[i].charAt(j) == 'L') l = new int[]{i, j};
                if (maps[i].charAt(j) == 'E') e = new int[]{i, j};
            }
        }
        
        int sTol = bfs(s, l);
        if(sTol == -1){
            return -1;
        }
        int answer = bfs(l, e);
        if (answer == -1) {
            return -1;
        }
        
        return sTol + answer;
    }
    
    // 최소시간 = bfs(queue)
    public int bfs(int[] start, int[] target) { 
        ArrayDeque<Node> q = new ArrayDeque<>();
        int[][] visited = new int[N][M];
        
        q.addLast(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = 1;
        
        while(!q.isEmpty()) {
            Node adj = q.pollFirst();
            if(adj.row == target[0] && adj.col == target[1]) return adj.path;
            
            for(int[] dir : directions) {
                int newRow = adj.row + dir[0];
                int newCol = adj.col + dir[1];
                
                if (0 <= newRow && newRow < N && 0 <= newCol && newCol < M
                   && visited[newRow][newCol] == 0
                    &&  map[newRow].charAt(newCol) != 'X'
                   ) {
                    q.addLast(new Node(newRow, newCol, adj.path+1));
                    visited[newRow][newCol] = 1;
                }
            }
            
        }
        return -1;
    }
}