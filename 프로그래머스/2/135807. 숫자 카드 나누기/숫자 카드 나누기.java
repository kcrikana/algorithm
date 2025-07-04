import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int AGCD = arrayA[0];
        int BGCD = arrayB[0];
        for(int i=1; i<arrayA.length; i++) {
            AGCD = gcd(AGCD, arrayA[i]);
            BGCD = gcd(BGCD, arrayB[i]);
        }
        AGCD = isDivisor(AGCD, arrayB) ? AGCD : 0;
        BGCD = isDivisor(BGCD, arrayA) ? BGCD : 0;
        return Math.max(AGCD, BGCD);
    }
    
    int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    
    boolean isDivisor(int a, int[] arr) {
        for(int num : arr) {
            if(num%a == 0) return false;
        }
        return true;  
    }
}