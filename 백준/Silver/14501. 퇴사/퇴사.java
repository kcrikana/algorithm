import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] arr = new int[N];
		int[][] dp = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			arr[i] = T;
			for(int j=0; j<N; j++) {
				if(i+arr[i] <= N) dp[i][j] = P;
			}
		}
		int result = 0;
		for(int i=0; i<N; i++) {
			int max = 0;
			for(int j=0; j<N; j++) max = Math.max(dp[i][j], max);
			result = Math.max(result, max);
			for(int j=i+arr[i]; j<N; j++) dp[j][i] += max;
		}
		for(int i=0; i<N; i++) {
			result = Math.max(result, dp[N-1][i]);
		}
		System.out.println(result);
	}
}
