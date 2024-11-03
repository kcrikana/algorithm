import java.util.*;
class Solution {
    public long solution(int n) {
        final long mod = 1234567;
        long answer = 0;
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n >= 2) dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%mod;
        }
        return dp[n];
    }
}