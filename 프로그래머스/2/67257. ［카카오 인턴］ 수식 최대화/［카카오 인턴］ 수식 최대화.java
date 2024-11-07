// 3가지의 연산문자(+, -, *) -> 연산자의 우선순위를 자유롭게 재정의 가장 큰 숫자 제출
// 같은 순위의 연산자는 없어야 함 -> 만약 계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환하여 제출
import java.util.*;
class Solution {
    private static final String[][] percedences = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*-+".split(""),
        "*+-".split("")};
    
    private long calculate(long loperand, long roperand, String operation) {
        return switch(operation) {
                case "+" -> loperand + roperand;
                case "-" -> loperand - roperand;
                case "*" -> loperand * roperand;
                default -> 0;
        };
    }
    
    private long calculate(List<String> tokens, String[] precedence) {
        for(String op : precedence) {
            for(int i=0;i<tokens.size();i++) {
                if (tokens.get(i).equals(op)) {
                    long result = calculate(
                        Long.parseLong(tokens.get(i-1)), Long.parseLong(tokens.get(i+1)), 
                        tokens.get(i));
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1, String.valueOf(result));
                    i = i - 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
    
    public long solution(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while(tokenizer.hasMoreTokens()) tokens.add(tokenizer.nextToken());
        long answer = 0;
        
        for(String[] operation : percedences) {
            answer = Math.max(answer, Math.abs(calculate(new ArrayList<>(tokens), operation)));
        }
        
        return answer;
    }
}