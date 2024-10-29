import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] counts = new int[3];
        
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i ++){
            if(pattern1[i%pattern1.length] == answers[i]) {
                counts[0]++;
            }
            
            if(pattern2[i%pattern2.length] == answers[i]) {
                counts[1]++;
            }
            
            if(pattern3[i%pattern3.length] == answers[i]) {
                counts[2]++;
            }
        }
        
        int max = Arrays.stream(counts).max().getAsInt();
        
        for (int i = 0; i < counts.length; i++){
            if (counts[i] == max){
                answer.add(i+1);
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}