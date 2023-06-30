import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> nums = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i+1; j < numbers.length; j++){
                nums.add(numbers[i]+numbers[j]);
            }
        }
        
        return nums.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}