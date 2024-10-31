// want : 정현이가 원하는 제품
// number : 정현이가 원하는 제품의 수량
// discount : 마트에서 할인하는 제품
// return : 회원 등록시 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i=0;i<want.length;i++){
            map.put(want[i], number[i]);
        }
        
        boolean work = true;
        
        for (String key : map.keySet()) {
            int count = (int)Arrays.stream(Arrays.copyOfRange(discount, 0, 10))
                   .filter(value -> value.equals(key))
                   .count();
            map.put(key, map.get(key) - count);
            if(map.get(key) > 0){
                work = false;
            }
        }
        
        if(work) {
            answer++;
        }
        
        int from = 0;
        int to = 10;
        
        while (to < discount.length) {
            if(map.containsKey(discount[from])) {
                map.put(discount[from], map.get(discount[from])+1);
            }
            from++;
            if(map.containsKey(discount[to])) {
                map.put(discount[to], map.get(discount[to])-1);
            }
            to++;
            work = true;
            
            for (String key : map.keySet()) {
                if(map.get(key) > 0){
                    work = false;
                }
            }
            
            if(work) {
                answer++;
            }
        }
        
        return answer;
    }
}