import java.util.*;
class Solution {
    // brown : 갈색 격자의 수
    // yellow : 노란색 격자의 수
    // return : 카펫의 가로, 세로 크기를 순서대로 배열에 담아
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        for(int i=1;i<=Math.sqrt(yellow);i++){
            if (yellow/(double)i % 1 == 0) {
                int w = Math.max(yellow/i, i);
                int h = Math.min(yellow/i, i);
                if(2*w + 2*h + 4 == brown) {
                    return new int[]{w+2, h+2};
                }
            }
        }
        
        return answer;
    }
}