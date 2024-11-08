import java.util.*;
class Solution {
    // 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        List<String> list = new ArrayList<>(List.of(strings));
        Collections.sort(list, (o1, o2) -> 
                         o1.charAt(n) - o2.charAt(n) == 0 ? o1.compareTo(o2) : o1.charAt(n) - o2.charAt(n));
        
        return list.toArray(new String[0]);
    }
}
