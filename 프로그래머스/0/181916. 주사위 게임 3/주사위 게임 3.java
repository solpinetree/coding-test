import java.util.*;
import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        List<Integer> cnt = new ArrayList<>(Collections.nCopies(7, 0));
        int p = 0, q = 0;
        
        cnt.set(a, cnt.get(a) +1);
        cnt.set(b, cnt.get(b) +1);
        cnt.set(c, cnt.get(c) +1);
        cnt.set(d, cnt.get(d) +1);
        
        int max = cnt.stream().max(Integer::compareTo).orElse(0);
        int min = cnt.stream().min(Integer::compareTo).orElse(0);
        
        if(max == 4) {
            return a * 1111;
        } else if(max == 3) {
            p = cnt.indexOf(3);
            q = cnt.indexOf(1);
            return (10*p+q) * (10*p+q); 
        } else if(max == 2){
            p = cnt.indexOf(2);
            q = cnt.lastIndexOf(2);
            if(p!=q){
                return (p+q) * Math.abs(p-q);
            } else {
                q = cnt.indexOf(1);
                int r = cnt.lastIndexOf(1);
                return q*r;
            }
        } 
        
        return List.of(a, b, c, d).stream().min(Integer::compareTo).orElse(0);
    }
}