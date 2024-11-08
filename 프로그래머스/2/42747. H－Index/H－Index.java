import java.util.*;
class Solution {
    // 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면
    // h의 최댓값이 이 과학자의 H-index
    // citations : 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열
    // return : 이 과학자의 H-Index
    public int solution(int[] citations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++) if(!map.containsKey(citations[i])) map.put(citations[i], i);
        int answer = 0;
        int n = citations.length;
        int over = n;
        for(int i=1;i<=citations[n-1];i++) {
            if(map.containsKey(i)) {
                over = n - map.get(i);   
                if(over >= i) answer = i; 
                over--;
                continue;
            } 
            if(over >= i) answer = i; else break;
        }
               
        return answer;
    }
}