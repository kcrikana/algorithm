import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[n];
        Arrays.fill(dp, 121);
        dp[0] = 0;
        for(int[] trace : info) {
            for(int i=n-1; i>=0; i--) {
                dp[i] += trace[1];
                if(i - trace[0] >= 0) dp[i] = Math.min(dp[i], dp[i-trace[0]]);
            }
        }
        for(int i=0; i<n; i++) {
            if(dp[i] < m) return i;
            
        }
        
        return -1;
    }
}