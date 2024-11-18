import java.util.*;
class Solution {
    // skill : 선행 스킬 순서
    // skill_trees : 유저들이 만든 스킬트리
    // return : 가능한 스킬트리 개수
    public int solution(String skill, String[] skillTrees) {
        return (int) Arrays.stream(skillTrees)
            .map(s -> s.replaceAll("[^" + skill + "]", ""))
            .filter(skill::startsWith)
            .count();
    }
}