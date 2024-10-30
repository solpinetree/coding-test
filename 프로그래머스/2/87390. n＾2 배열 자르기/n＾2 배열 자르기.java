import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        // row = left / n
        // col = left % n
        // value = Math.max(row, col) + 1
        
        int[] answer = new int[(int)(right-left+1)];
        long row, col;
        
        for (long i=left;i<=right;i++){
            row = i / n;
            col = i % n;
            answer[(int)(i-left)] = (int)Math.max(row, col) + 1;
        }
        
        return answer;
    }
}