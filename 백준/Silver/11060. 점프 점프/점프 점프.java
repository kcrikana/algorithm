import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = -1;
		arr = new int[N];
		visit = new boolean[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		q.offer(0);
		visit[0] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			int count = q.poll();
			if(now == N-1) {
				ans = count;
				return;
			}
			for(int i=1; i<=arr[now]; i++) {
				int next = i+now;
				if(next == N-1) {
					ans = count+1;
					return;
				}
				else if(next < N) {
					if(!visit[next]) {
						visit[next] = true;
						if(arr[next]!=0) {
							q.offer(next);
							q.offer(count+1);
						}
					}
				}
			}
		}
	}
}