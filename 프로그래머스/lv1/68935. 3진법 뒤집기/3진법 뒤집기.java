class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        sb.reverse();
        return Integer.valueOf(sb.toString(), 3);
    }
}