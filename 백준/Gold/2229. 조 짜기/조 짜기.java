import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		int max = 0;
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			for(int j=1; j<i; j++) {
				max = Math.max(max, Math.abs(arr[i]-arr[j])+dp[j-1]);
			}
			dp[i] = max;
		}
		System.out.println(dp[N]);
	}
}