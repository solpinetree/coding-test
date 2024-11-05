class Solution {
    // 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로
    // s 가 의미하는 원래 숫자를 return
    public int solution(String s) {
        s = s.replace("zero", "0");
        s = s.replace("one", "1");
        s = s.replace("two", "2");
        s = s.replace("three", "3");
        s = s.replace("four", "4");
        s = s.replace("five", "5");
        s = s.replace("six", "6");
        s = s.replace("seven", "7");
        s = s.replace("eight", "8");
        s = s.replace("nine", "9");
        
        return Integer.parseInt(s);
    }
}