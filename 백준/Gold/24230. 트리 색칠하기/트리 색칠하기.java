import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] color;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		color = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) color[i] = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) list[i] = new ArrayList<>();
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			list[num1].add(num2);
			list[num2].add(num1);
		}
		System.out.println(dfs(1, 0));
	}

	static int dfs(int now, int parent) {
		int sum = color[now] == color[parent] ? 0 : 1;
		for(int next : list[now]){
			if(next == parent) continue;
			sum += dfs(next, now);

		}
		return sum;
	}
}