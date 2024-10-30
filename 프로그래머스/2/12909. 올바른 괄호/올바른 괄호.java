import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(Character c : s.toCharArray()) {
            if (c.equals('(')) {
                stack.push(c);
            } else {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        
        
        return stack.isEmpty() ? true : false;
    }
}