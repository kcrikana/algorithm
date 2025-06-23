import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k+1];
		int[] arr = new int[n];
		Arrays.fill(dp,2000000000);
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num <= k) dp[num] = 1;
			arr[i] = num;
		}
		for(int i=1; i<=k; i++) {
			for(int j=0; j<n; j++) {
				int pastIdx = i-arr[j];
				if(pastIdx >= 1) dp[i] = Math.min(dp[i], dp[pastIdx]+1);
			}
		}
		System.out.println(dp[k] == 2000000000 ? -1 : dp[k]);

	}
}