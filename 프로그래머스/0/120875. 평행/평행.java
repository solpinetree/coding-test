import java.util.*;
class Solution {
    private double getSlope(int[] c1, int[] c2) {
        return (double) (c2[1]- c1[1]) / (c2[0] - c1[0]);
    }
    public int solution(int[][] dots) {
        int[] a = dots[0];
        int[] b = dots[1];
        int[] c = dots[2];
        int[] d = dots[3];
        
        if(getSlope(a, b) == getSlope(c, d)) return 1;
        if(getSlope(a, c) == getSlope(b, d)) return 1;
        if(getSlope(a, d) == getSlope(b, d)) return 1;
        
        return 0;
    }
}