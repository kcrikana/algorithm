import java.math.BigInteger;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        if(N == 0) System.out.println(0);
        else if(N == 1) System.out.println(1);
        else {
            BigInteger[] dp = new BigInteger[N+1];
            dp[0] = BigInteger.ZERO;
            dp[1] = BigInteger.ONE;
            for(int i=2; i<=N; i++) dp[i] = dp[i-1].add(dp[i-2]);
            System.out.println(dp[N]);
        }
    }
}