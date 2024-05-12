import java.util.*;
class Solution {
    static final long MOD = 1000000007;
    public int solution(int n) {
        // 원래 dp배열
        long[] dp = new long[100001];
        // 누적합임
        long[] dp2 = new long[100001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 10;
        dp[4] = 23;
        dp[5] = 62;
        dp[6] = 170;
        dp2[0] = 1;
        dp2[1] = 1;
        dp2[2] = 3;
        dp2[3] = 11;
        dp2[4] = 24;
        dp2[5] = 65;
        dp2[6] = 181;
        // 3개씩 늘어날때마다 누적합으로 계산
        for(int i=7; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]*2 + dp[i-3]*5 + dp2[i-4]*2 + dp2[i-5]*2 + dp2[i-6]*4)%MOD;
            dp2[i] = (dp[i] + dp2[i-3])%MOD;
        }
        return (int)dp[n];
    }
}