import java.util.*;

class Solution {
    // 게임 화면의 격자의 상태가 담긴 2차원 배열 board
    // 크레인을 작동시킨 위치가 담긴 배열 moves
    // return : 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] lastIdx = new int[n];
        Arrays.fill(lastIdx, -1);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[j][i]!=0){
                    lastIdx[i] = j;
                    break;
                }
            }
        }
        
        for(int move : moves) {
            if(lastIdx[move-1]!=-1){
                if(!stack.isEmpty() && stack.peek() == board[lastIdx[move-1]][move-1]) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(board[lastIdx[move-1]][move-1]);    
                }
                
                board[lastIdx[move-1]][move-1] = 0;
                if(lastIdx[move-1] == n-1){
                    lastIdx[move-1] = -1;
                }else {
                    lastIdx[move-1]++;
                }  
            }
        }
        
        return answer;
    }
}