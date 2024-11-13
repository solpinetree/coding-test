class Solution {
    // numbers : 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열
    // return : numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수
    public int solution(int[] numbers) {
        int answer = 0;
        int[] memo = new int[10];
        
        for(int num : numbers) {
            memo[num] = 1;
        }
        
        for(int i = 0; i < 10; i++) {
            if(memo[i] == 0) answer += i;
        }
        
        return answer;
    }
}