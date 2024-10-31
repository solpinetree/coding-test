// records : 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록
// return : 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메세지
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> nickname = new HashMap<>();
        
        for (String r : record) {
            String[] arr = r.split(" ");
            if (arr[0].equals("Enter") || arr[0].equals("Change")) {
                nickname.put(arr[1], arr[2]);
            } 
        }
        
        for (String r : record) {
            String[] arr = r.split(" ");
            if (arr[0].equals("Enter")) {
                answer.add(nickname.get(arr[1]) + "님이 들어왔습니다.");
            } else if (arr[0].equals("Leave")) {
                answer.add(nickname.get(arr[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}