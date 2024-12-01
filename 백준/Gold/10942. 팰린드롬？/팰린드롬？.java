import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] dp = new int[N][N];
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				if(j == i) dp[j][i] = 1;
				else if(i-j == 1) dp[j][i] = (arr[j] == arr[i]) ? 1 : 0;
				else dp[j][i] = (arr[j]==arr[i] && dp[j+1][i-1] == 1) ? 1 : 0;
			}
		}

		int M = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		while(M-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			sb.append(dp[start][end]).append('\n');
		}
		System.out.println(sb);
	}
}