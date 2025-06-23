import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[] dp = new long[k+1];
		int[] arr = new int[n];
		Arrays.fill(dp, 200000000000l);
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num <= k) dp[num] = 1l;
			arr[i] = num;
		}
		for(int i=1; i<=k; i++) {
			for(int j=0; j<n; j++) {
				int pastIdx = i-arr[j];
				if(pastIdx >= 1) dp[i] = Math.min(dp[i], dp[pastIdx]+1l);
			}
		}
		System.out.println(dp[k] == 200000000000l ? -1l : dp[k]);

	}
}