// 대기실 = 5개, 5x5 크기
// |r1-r2| + |c1-c2| > 2 -> 응시자들끼리 거리두기
// 단 응시자 여펭 파티션이 있을 경우에는 거리두기 안해도 됨
// P : 응시자가 앉아있는 자리, O : 빈테이블, X : 파티션
// bfs ->  queue
import java.util.*;
class Solution {
    private static int[] dr = {1, 0, -1, 0};
    private static int[] dc = {0, 1, 0, -1};
    
    private int getDistance(Node parent, Node child) {
        return Math.abs(child.row - parent.row) + Math.abs(child.col - parent.col);
    }
    
    private static class Node {
        final int row, col;
        Node(int row, int col) {
            this.row = row; this.col = col;
        }
    }
    
    private boolean bfs(char[][] room) {
        ArrayDeque<Node> q = new ArrayDeque<>();
            
        for (int k = 0; k < 5; k++){
            for (int l = 0; l < 5; l++){
                if(room[k][l]=='P'){
                    Node parent = new Node(k, l);
                    q.addLast(parent);
                    int[][] visited = new int[5][5];
                    visited[k][l] = 1;
                    while(!q.isEmpty()) {
                        Node cur = q.pollFirst();
                        
                        // System.out.println(cur.row + " " + cur.col + " " + getDistance(parent, cur));

                        if(room[cur.row][cur.col] == 'P' && !cur.equals(parent)) return false;

                        for(int m = 0; m < 4; m++){
                            int newRow = cur.row + dr[m]; int newCol = cur.col + dc[m];
                            Node nNode = new Node(newRow, newCol);
                            if(0 <= newRow && newRow < 5 && 
                               0 <= newCol && newCol < 5 && 
                               visited[newRow][newCol] != 1 &&
                               room[newRow][newCol] != 'X' &&
                               getDistance(parent, nNode) <= 2){
                                q.addLast(nNode);
                                visited[newRow][newCol] = 1;
                            }
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5 ; i++) {
            String[] p = places[i];
            char[][] room = new char[5][5];
            for (int j = 0; j < 5; j++) 
                room[j] = p[j].toCharArray();
            
            System.out.println("bfs(" + i + ")");
            if(!bfs(room)) answer[i] = 0;
            else answer[i] = 1;
        }
        
        return answer;
    }
}

// "POOPX", 
// "OXPXP", 
// "PXXXO", 
// "OXXXO", 
// "OOOPP"