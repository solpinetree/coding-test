import java.util.*;
class Solution {
    // id_list : 이용자의 ID
    // report : 각 이용자가 신고한 이용자의 ID 
    // k : 정지 기준이 되는 신고 횟수
    // return : 각 유저별로 처리 결과 메일을 받은 횟수
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, Set<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> idMap = new HashMap<>();
        
        for (int i=0;i<id_list.length;i++) {
            idMap.put(id_list[i], i);
        }
        
        for (String r : report) {
            String from = r.split(" ")[0];
            String to = r.split(" ")[1];
            
            reportMap.putIfAbsent(to, new HashSet<>());
            reportMap.get(to).add(from);
        }
        
        for (String key : reportMap.keySet()) {
            if(reportMap.get(key).size() >= k) {
                for (String id : reportMap.get(key)) {
                    answer[idMap.get(id)]++;
                }
            }
        }
        
        return answer;
    }
}