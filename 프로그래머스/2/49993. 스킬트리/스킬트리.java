import java.util.*;
class Solution {
    // skill : 선행 스킬 순서
    // skill_trees : 유저들이 만든 스킬트리
    // return : 가능한 스킬트리 개수
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        char[] skills = skill.toCharArray();
        HashMap<Character, Integer> skillMap = new HashMap<>();
        for(int i = 0; i < skills.length; i++) {
            skillMap.put(skills[i], i);
        }
        
        
        int n = skills.length;
        for(String tree : skill_trees) {
            System.out.println(tree);
            int idx = 0;
            for(char t : tree.toCharArray()) {
                if(skillMap.containsKey(t)) {
                    if(idx < skillMap.get(t)) {
                        System.out.println(idx);
                        System.out.println(skillMap.get(t));
                        answer--;
                        break;
                    } else {
                        idx = skillMap.get(t) + 1;
                    }
                }
            }
        }
        
        return answer;
    }
}