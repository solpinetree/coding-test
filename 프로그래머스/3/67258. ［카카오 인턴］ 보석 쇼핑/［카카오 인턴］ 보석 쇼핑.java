import java.util.*;
class Solution {
    // gems : 진열된 순서대로 보석들의 이름이 저장된 배열
    // return : 모든 보석을 하나 이상 포함하는 가장 짧은 구간
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> gemCount = new HashMap<>();
        int start = 0; int end = gems.length - 1;
        int s = 0; int e = s;
        for(String g : gems) set.add(g);
        gemCount.put(gems[s], 1);
        
        while(e <= gems.length) {
            if(gemCount.keySet().size() == set.size()) {
                if(e - s < end - start) {
                    start = s; end = e;
                }
                gemCount.put(gems[s], gemCount.get(gems[s]) - 1);
                if(gemCount.get(gems[s]) == 0) gemCount.remove(gems[s]);
                s++;
            } else {
                if(e < gems.length - 1) {
                    e++;
                    gemCount.put(gems[e], gemCount.getOrDefault(gems[e], 0) + 1);
                } else break;
            }
        }
        
        return new int[]{start+1, end + 1};
    }
}