class Solution {
    public int solution(int n) {
        // n을 3진법 상에서 앞뒤로 뒤집 ->
        // 10진법으로 표현하여 return
        
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        sb.reverse();
        return Integer.parseInt(sb.toString() ,3);
    }
}