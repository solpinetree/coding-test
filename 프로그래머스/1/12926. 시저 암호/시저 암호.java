// 시저 암호 = 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식
// AB를 1만큼 밀면 -> BC
// AB를 3만큼 밀면 -> DE
// z는 1만큼 밀면 -> a
// 문자열 s를 n만큼 민 암호문을 만들어라
// 공백은 밀어도 공백
class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        
        for(int i=0;i<arr.length;i++) {
            char origin = arr[i];
            if(origin == ' ') continue;
            
            for(int j=0;j<n;j++) {
                if(origin == 'z') {
                    origin = 'a';
                } else if(origin == 'Z') {
                    origin = 'A';
                } else {
                    origin ++;
                }
            }
            arr[i] = origin;
        }
        
        return new String(arr);
    }
}