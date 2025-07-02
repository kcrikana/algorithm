import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<ArrayList<Integer>> list;
	static int[] arr;
	static boolean isTruth;

	static final int RED = 1;
	static final int GREEN = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			list = new ArrayList<>();
			isTruth = true;
			for(int i=0; i<=n; i++) list.add(new ArrayList<>());
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				list.get(num1).add(num2);
				list.get(num2).add(num1);
			}
			for(int i=1; i<=n; i++) {
				if(!isTruth) break;
				if(arr[i] == 0) dfs(i, RED);
			}
			sb.append(isTruth ? "possible" : "impossible").append('\n');
		}
		System.out.println(sb);
	}

	static void dfs(int start, int color) {
		arr[start] = color;
		for(int next : list.get(start)) {
			if(arr[next] == color) {
				isTruth = false;
				return;
			}
			if(arr[next] == 0) dfs(next, -color);
		}
	}
}
