import java.util.*;
// 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들 -> 코스요리 메뉴로 구성
// 최소 2가지 이상의 단품메뉴로 구성
// 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합
class Solution {
    // orders : 각 손님들이 주문한 단품메뉴들
    // course : 코스요리를 구성하는 단품메뉴들의 갯수
    // return : 새로 추가하게 될 코스요리의 메뉴 구성, 오름차순으로 정렬
    // 만약 가장 많이 함께 준비된 메뉴 구성이 여러 개 -> 모두 return 
    private void generate(String order, String comb, HashSet<String> set) {
        set.add(comb);
        char lastWord = comb.charAt(comb.length()-1);
        for(int i = order.indexOf(lastWord) + 1; i < order.length(); i++) { 
            generate(order, comb + order.charAt(i), set);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String order : orders) {
            HashSet<String> set = new HashSet<>();
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            for(char c : arr) {
                generate(new String(arr), "" + c, set);   
            }
            
            for(String comb : set) {
                map.put(comb, map.getOrDefault(comb, 0) + 1);
            }
        }
        
        HashMap<Integer, List<String>> courseMap = new HashMap<>();
        
        for(String comb : map.keySet()) {
            courseMap.putIfAbsent(comb.length(), new ArrayList<>());
            courseMap.get(comb.length()).add(comb);
        }
        
        for(int c : courseMap.keySet()) {
            Collections.sort(courseMap.get(c), (c1, c2) -> map.get(c2) - map.get(c1));
        }
        
        List<String> answer = new ArrayList<>();
        for(int c : course) {
            if(courseMap.containsKey(c)) {
                int max = map.get(courseMap.get(c).get(0));
                if(max >= 2) {
                    for(String o : courseMap.get(c)) {
                        if(map.get(o) == max) {
                            answer.add(o);
                        }
                    }
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
}