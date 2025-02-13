import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		StringBuilder sb = new StringBuilder();
		Collections.sort(list);
		sb.append(list.size()).append('\n');
		for(int num : list) sb.append(num).append('\n');
		System.out.println(sb);
	}
	static void dfs(int idx, int end) {
		if(!visited[arr[idx]]) {
			visited[idx] = true;
			dfs(arr[idx], end);
			visited[idx] = false;
		}
		if(arr[idx] == end) list.add(end);
	}
}