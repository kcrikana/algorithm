import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		final long MOD = 1000000000l;
		long[] dp = new long[11];
		long[] arr = new long[10];
		for(int i=1; i<=9; i++) arr[i] = dp[i] = 1;
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				if(j == 0) arr[j] = dp[j+1]%MOD;
				else arr[j] = (dp[j-1] + dp[j+1])%MOD;
			}
			for(int j=0; j<=9; j++) dp[j] = arr[j];
		}
		long result = 0l;
		for(int i=0; i<=9; i++) {
			result += dp[i];
		}
		System.out.println(result%MOD);
	}
}