import java.util.*;
class Solution {
    // 최솟값 -> bfs(queue)
    public static ArrayDeque<Position> q = new ArrayDeque<>();
    public static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        int row = 0, col = 0;
        
        q.addLast(new Position(row, col, 1));
        return bfs(maps, n, m);
    }
    
    public int bfs(int[][] maps, int n, int m) {
        while(!q.isEmpty()) {
            Position p = q.pollFirst();
            
            if (p.row == n-1 && p.col == m-1) return p.path;
            
            for (int[] dir : directions) {
                int new_row = p.row + dir[0];
                int new_col = p.col + dir[1];
                
                if (0 <= new_row && new_row < n 
                    && 0 <= new_col && new_col < m
                    && maps[new_row][new_col] == 1) {
                    maps[new_row][new_col] = 0;
                    q.addLast(new Position(new_row, new_col, p.path + 1));
                }
            }
        }
        
        return -1;
    }
    
    class Position {
        int row, col, path;
        
        Position(int row, int col, int path) {
            this.row = row;
            this.col = col;
            this.path = path;
        }
    }
}