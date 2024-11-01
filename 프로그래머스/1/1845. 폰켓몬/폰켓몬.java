// N마리의 폰켓몬 중에서 N/2 마리를 가져가도 좋음
// 같은 종류의 폰켓몬은 같은 번호를 가지고 있음
// 다양한 종류의 폰켓몬을 가지길 원함. 
// 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 함.
// nums : N마리의 포켓몬 종류 번호가 담긴 배열
// return : N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을
// 선택하는 방법을 찾아, 그 때의 폰켓몬 종류 번호의 개수를 return하도록
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int take = nums.length/2;
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        
        for (int num : nums){
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }
        
        if(numsMap.keySet().size() >= take) {
            answer = take;
        } else { 
            answer = numsMap.keySet().size();
        }
        
        return answer;
    }
}