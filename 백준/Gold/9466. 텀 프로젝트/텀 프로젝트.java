import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] visited, complete;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int N = Integer.parseInt(bf.readLine());
			arr = new int[N+1];
			visited = new boolean[N+1];
			complete = new boolean[N+1];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			count = 0;
			for(int i=1; i<=N; i++) {
				if(complete[i]) continue;
				dfs(i);
			}
			sb.append(N-count).append('\n');
		}
		System.out.println(sb);
	}

	static void dfs(int idx) {
		if(complete[idx]) return;
		if(visited[idx]) {
			complete[idx] = true;
			count++;
		}
		visited[idx] = true;
		dfs(arr[idx]);
		complete[idx] = true;
		visited[idx] = false;
	}
}