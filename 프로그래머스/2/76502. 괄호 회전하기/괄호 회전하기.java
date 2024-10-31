import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for(int i=0;i<n;i++) {
            Stack<Character> stack = new Stack<>();
            boolean result = true;
            for(int j=0;j<n;j++){
                char c = arr[(i+j)%n];
                if(!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if(stack.isEmpty() || stack.peek() != map.get(c)){
                        result = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (result && stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}