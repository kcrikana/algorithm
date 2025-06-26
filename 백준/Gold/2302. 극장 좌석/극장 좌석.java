import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] dp = new int[41];
		int[] vip = new int[M+1];
		for(int i=1; i<=M; i++) vip[i] = Integer.parseInt(br.readLine());
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=N; i++) dp[i] = dp[i-1]+dp[i-2];
		int result = 1;
		for(int i=1; i<=M; i++) {
			int num = vip[i]-vip[i-1]-1;
			result *= dp[num];
		}
		result *= dp[N-vip[M]];
		System.out.println(result);
	}
}