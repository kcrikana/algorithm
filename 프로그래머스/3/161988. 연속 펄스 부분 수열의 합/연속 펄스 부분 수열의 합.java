import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = Integer.MIN_VALUE;
        int N = sequence.length;
        long[] dp = new long[2];
        for(int i=0; i<N; i++) {
            int num1 = sequence[i];
            int num2 = sequence[i];
            
            if(i%2 == 0) num2 *= -1;
            else num1 *= -1;
            
            dp[0] = Math.max(dp[0]+num1, 0);
            dp[1] = Math.max(dp[1]+num2, 0);
            
            answer = Math.max(dp[0], answer);
            answer = Math.max(dp[1], answer);

        }
        return answer;
    }
}