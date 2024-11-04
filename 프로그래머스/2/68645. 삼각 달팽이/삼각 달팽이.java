import java.util.*;

class Solution {
    // 밑변의 길이와 높이가 n인 삼각형에서 
    // 맨위 꼭짓점 -> 반시계 방향으로 달팽이 채우기를 진행한 후, 
    // return : 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열
    private static class Point {
        final int row, col;
        Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, -1}};
        
        int total = (1 + n) * n / 2;
        int dirN = 0;
        Point cur = new Point(0, 0);
        arr[0][0] = 1;
        int newRow = 1; int newCol = 0;
        
        for(int i = 2; i <= total ; i++){
            newRow = cur.row + dir[dirN%3][0]; newCol = cur.col + dir[dirN%3][1];
            if(!(0 <= newRow && newRow < n && 0 <= newCol && newCol < n && arr[newRow][newCol] == 0)) {
                dirN++;
                newRow = cur.row + dir[dirN%3][0]; newCol = cur.col + dir[dirN%3][1];
            }
            arr[newRow][newCol] = i;
            cur = new Point(newRow, newCol);
         }
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]!=0){
                    answer.add(arr[i][j]);
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}