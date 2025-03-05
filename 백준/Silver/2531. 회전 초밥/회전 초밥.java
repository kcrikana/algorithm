import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] visited = new int[d+1];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		int count = 1;
		int result = 0;
		visited[c]++;
		for(int i=0; i<N+k-1; i++) {
			int now = arr[i%N];
			if(i >= k) {
				visited[arr[i-k]]--;
				if(visited[arr[i-k]] == 0) count--;
			}
			if(visited[now] == 0) count++;
			visited[now]++;
			result = Math.max(result, count);
		}
		System.out.println(result);
	}
}