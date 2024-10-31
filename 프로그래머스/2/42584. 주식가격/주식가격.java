import java.util.*;

class Solution {
    // prices : 초 단위로 기록된 주식가격 
    // return : 가격이 떨어지지 않은 기간은 몇초인지
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(prices[n-1], n-1));
        answer[n-1] = 0;
        
        for (int i=n-2;i>=0;i--) {
            while(!stack.isEmpty()) {
                Pair pair = stack.peek();
                if (pair.getPrice() >= prices[i]) {
                    stack.pop();
                } else {
                    answer[i] = pair.getIdx() - i;
                    break;
                }
            }
            stack.push(new Pair(prices[i], i));
            
            if (answer[i] == 0){
                answer[i] = n-1-i;
            }
        }
        
        return answer;
    }
    
    class Pair {
        int price;
        int idx;
        
        Pair(int price, int idx) {
            this.price = price;
            this.idx = idx;
        }
        
        public int getPrice() {
            return price;
        }
        public int getIdx() {
            return idx;
        }
    }
}