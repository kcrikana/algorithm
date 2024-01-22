import java.util.*;
class Solution {
    public int solution(int n, int k) {
        String nums = Integer.toString(n,k);
        int ans = 0;
        for(String num : nums.split("0")) {
            if(num.equals("")) continue;
            if(isPrime(num)) ans++;
        }
        return ans;
    }
    boolean isPrime(String num) {
        long res = Long.parseLong(num);
        if(res == 1) return false;
        for(int i=2; i<=Math.sqrt(res); i++) {
            if(res%i==0) return false;
        }
        return true;
    }
}