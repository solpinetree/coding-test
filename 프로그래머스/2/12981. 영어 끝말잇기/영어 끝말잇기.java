import java.util.*;
class Solution {
    // n : 사람의 수, words : 사람들이 순서대로 말한 단어
    // return : 가장 먼저 탈락하는 사람의 번호, 그 사람이 자신의 몇 번째 차례에 탈락하는지
    
    // 마지막 사람 -> 1번부터 다시 시작
    // 이전에 등장했던 단어는 사용할 수 없음
    // 한 글자인 단어는 X
    // 탈락자가 생기지 않는다면, [0, []]
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        char prev = words[0].charAt(words[0].length() -1);

        for (int i=1;i<words.length;i++){
            if((words[i].charAt(0) != prev) || set.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            prev = words[i].charAt(words[i].length() -1);
            set.add(words[i]);
        }

        return answer;
    }
}