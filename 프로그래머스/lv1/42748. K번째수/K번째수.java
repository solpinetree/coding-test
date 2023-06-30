import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            List<Integer> nums = new ArrayList<>();
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            
            for(int j = start; j <= end; j++) nums.add(array[j]);
            
            Collections.sort(nums);
            answer[i] = nums.get(commands[i][2]-1);
        }
        
        return answer;
    }
}