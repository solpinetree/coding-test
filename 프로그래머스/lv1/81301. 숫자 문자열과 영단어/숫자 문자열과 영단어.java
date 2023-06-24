import java.util.HashMap;

class Solution {
    public int solution(String s) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        char[] s_arr = s.toCharArray();
        String res = "";
        
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s_arr[i])){
                res = res + s_arr[i];
                continue;
            }
            
            String temp = "";
            while(i<s.length() && !Character.isDigit(s_arr[i])){
                temp = temp + s_arr[i];
                i++;
                
                if(map.containsKey(temp)){
                    break;
                }
            }
            
            res = res + map.get(temp);
            i--;
        }
        
        System.out.println(res);
        
        return Integer.parseInt(res);
    }
}