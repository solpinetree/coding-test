import java.util.*;
class Solution {
    // numbers: 순서대로 누를 번호다 담긴 배열
    // hand : 왼손잡이인지 오른손잡이인지
    // return : 각 번호를 누른 엄지손가락이 왼손이지 오른손인지를 나타내는 연속된 문자열
    private static StringBuilder answer = new StringBuilder();
    private int[] curL = new int[]{3, 0};
    private int[] curR = new int[]{3, 2};
    
    private void updateCurL(int row, int col) {
        answer.append("L");
        curL[0] = row; curL[1] = col;
    }
    
    private void updateCurR(int row, int col) {
        answer.append("R");
        curR[0] = row; curR[1] = col;
    }
    
    public String solution(int[] numbers, String hand) {
        int[][] keypad = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(keypad[i][j] != -1) {
                    map.putIfAbsent(keypad[i][j], new ArrayList<>());
                    map.put(keypad[i][j], List.of(i, j));
                }
            }
        }
        
        for(int num : numbers) {
            int row = map.get(num).get(0);
            int col = map.get(num).get(1);
            
            if(col == 0) updateCurL(row, col);
            else if(col == 2) updateCurR(row, col);
            else {
                int diffL = Math.abs(curL[0] - row) + Math.abs(curL[1] - col);
                int diffR = Math.abs(curR[0] - row) + Math.abs(curR[1] - col);
                if(diffL < diffR) updateCurL(row, col);
                else if(diffR < diffL) updateCurR(row, col);
                else if(hand.equals("right")) updateCurR(row, col);
                else updateCurL(row, col);
            }
        }
        
        return answer.toString();
    }
}