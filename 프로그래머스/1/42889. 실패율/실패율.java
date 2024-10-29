import java.util.*;

class Solution {
    // N : 전체 스테이지의 개수
    // stages : 사용자가 멈춰있는 스테이지의 번호가 담긴 배열
    // 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 번호를 return
    // 실패율 : stages[] == 스테이지 / stages[] >= 스테이지
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] challengers = new int[N+1];
        
        for (int stage : stages) {
            for (int i=0;i<stage;i++) {
                challengers[i]++;
            }
        }
        
        HashMap<Integer, Float> fails = new HashMap<>();
        
        for (int i=0;i<N;i++){
            if (challengers[i] + challengers[i+1] != 0) {
                fails.put(i+1, (float)(challengers[i] - challengers[i+1])/challengers[i]);    
            } else {
                fails.put(i+1, 0.0f);
            }
        }
        
        return fails.entrySet().stream().sorted(
            (o1, o2) -> Float.compare(o2.getValue(), o1.getValue())
        ).mapToInt(HashMap.Entry::getKey).toArray();
    }
}