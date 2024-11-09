import java.util.*;
class Solution {
    // numbers : 0  또는 양의 정수가 담긴 배열
    // return : 순서를 재배치하여 만들 수 있는 가장 큰 수
    public String solution(int[] numbers) {
        numbers = Arrays.stream(numbers)
                      .boxed()
                      .sorted((o1, o2) -> {
                    String str1 = String.valueOf(o1);
                    String str2 = String.valueOf(o2);
                    Long l1 = Long.parseLong(str1+str2);
                    Long l2 = Long.parseLong(str2+str1);
                    return (int)(l2 - l1);
                }).mapToInt(Integer::intValue).toArray();
        StringBuilder sb = new StringBuilder();
        for(int num : numbers) sb.append(String.valueOf(num));
        return sb.toString().replaceAll("^0+", "0");
    }
}