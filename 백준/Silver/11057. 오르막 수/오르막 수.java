import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		final long MOD = 10007;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		long[][] dp = new long[N+1][10];
		for(int i=0; i<10; i++) {
			dp[1][i] = 1;
		}
		for(int i=2; i<N+1; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<=j; k++) {
					dp[i][j] += dp[i-1][k];
				}
				dp[i][j] %= MOD;
			}
		}
		long ans = 0;
		for(int i=0; i<10; i++) ans += dp[N][i];
		System.out.println(ans%MOD);
	}
}