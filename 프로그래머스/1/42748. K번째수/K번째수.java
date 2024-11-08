import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        for(int i=0;i<commands.length;i++) {
            int[] c = commands[i];
            int[] arr = Arrays.copyOfRange(array, c[0] - 1, c[1]);
            Arrays.sort(arr);
            result[i] = arr[c[2] - 1];
        }
        
        return result;
    }
}