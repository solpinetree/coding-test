import java.util.*;

class Solution {
    // array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환
    // 나누어 떨어지는 값이 하나도 없다면 [-1]
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        for (int num : arr) {
            if (num%divisor == 0) {
                list.add(num);
            }
        }
        
        if (list.size() == 0) {
            return new int[]{-1};
        }
        
        Collections.sort(list);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}