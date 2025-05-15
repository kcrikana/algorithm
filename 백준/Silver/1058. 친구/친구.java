import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 100000000;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dist = new int[N+1][N+1];
		int ans = 0;
		for(int i=1; i<=N; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=1; j<=N; j++) {
				if(i != j) dist[i][j] = arr[j-1] == 'Y' ? 1 : INF;
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(j != k) dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
				}
			}
		}
		for(int i=1; i<=N; i++) {
			int count = 0;
			for(int j=1; j<=N; j++) {
				if(dist[i][j] == 1 || dist[i][j] == 2) count++;
			}
			ans = Math.max(ans, count);
		}
		System.out.println(ans);
	}
}