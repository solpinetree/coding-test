import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> cards1Q = new ArrayDeque<>(List.of(cards1));
        ArrayDeque<String> cards2Q = new ArrayDeque<>(List.of(cards2));
        ArrayDeque<String> goalQ = new ArrayDeque<>(List.of(goal));
        
        while(!cards1Q.isEmpty() && !cards2Q.isEmpty() && !goalQ.isEmpty()) {
            if(cards1Q.peekFirst().equals(goalQ.peekFirst())) {
                goalQ.pollFirst();
                cards1Q.pollFirst();
            } else if(cards2Q.peekFirst().equals(goalQ.peekFirst())) {
                goalQ.pollFirst();
                cards2Q.pollFirst();
            } else {
                return "No";
            }
        }
        
        while(!cards1Q.isEmpty() && !goalQ.isEmpty()) {
            if(cards1Q.peekFirst().equals(goalQ.peekFirst())) {
                goalQ.pollFirst();
                cards1Q.pollFirst();
            } else {
                return "No";
            }
        }
        
         while(!cards2Q.isEmpty() && !goalQ.isEmpty()) {
            if(cards2Q.peekFirst().equals(goalQ.peekFirst())) {
                goalQ.pollFirst();
                cards2Q.pollFirst();
            } else {
                return "No";
            }
        }
        
        return goalQ.isEmpty() ? "Yes" : "No";
    }
}