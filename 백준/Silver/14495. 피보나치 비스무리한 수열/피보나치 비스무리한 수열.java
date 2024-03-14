import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[] dp = new long[N+1];
        for(int i=0; i<=N; i++) {
            if(i<=3) dp[i] = 1;
            else dp[i] = dp[i-1] + dp[i-3];
        }
        System.out.println(dp[N]);
    }
}