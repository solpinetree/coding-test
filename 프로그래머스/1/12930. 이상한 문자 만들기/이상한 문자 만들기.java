class Solution {
    // 각 단어는 하나 이상의 공백문자로 구분되어 있음
    // 단어의 짝수번째 알파벳은 대문자로, 홀수번재 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int offset = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' ') {
                offset = i + 1;
                sb.append(' ');
                continue;
            }
            
            if((i-offset) % 2 == 0){
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString();
    }
}