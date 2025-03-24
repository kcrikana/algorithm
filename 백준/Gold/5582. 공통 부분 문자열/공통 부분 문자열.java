import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] dp = new int[len1+1][len2+1];
		int result = 0;
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		System.out.println(result);
	}
}
