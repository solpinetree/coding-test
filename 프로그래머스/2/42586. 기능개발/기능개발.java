import java.util.*;

class Solution {
    // progresses : 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
    // speeds : 각 작업의 개발 속도가 적힌 정수 배열
    // return : 각 배포마다 몇 개의 기능이 배포되는지
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int days = 0, cnt = 0;
        
        for (int i=0;i<progresses.length;i++){
            int tmp = (int)Math.ceil((100-progresses[i])/(double)speeds[i]);
            if (days == 0) {
                days = tmp;
                cnt++;
            } else if (tmp <= days) {
                cnt++;
            } else {
                answer.add(cnt);
                cnt = 1;
                days = tmp;
            }
        }
        
        answer.add(cnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}