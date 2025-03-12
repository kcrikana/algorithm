import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[][] DP = new long[n][10];
			for(int i = 0; i < 10; i++) {
				DP[0][i] = 1;
			}

			for(int i = 1; i < n; i++) {
				for(int j = 9; j >= 0; j--) {
					if(j == 9) DP[i][j] = 1;
					else DP[i][j] += DP[i-1][j] + DP[i][j+1];
				}
			}

			long total = 0;
			for(int i = 0; i < 10; i++) {
				total += DP[n - 1][i];
			}
			sb.append(total).append("\n");
		}

		System.out.print(sb);
	}
}