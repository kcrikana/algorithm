import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		parent = new int[N+1];
		StringTokenizer st;
		for(int i=1; i<=N; i++) parent[i] = i;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1; j<=N; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now == 1) union(i,j);
			}
		}
		st = new StringTokenizer(bf.readLine());
		int start = 0;
		for(int i=0; i<M; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(i == 0) start = now;
			else if(parent[start] != func(now)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	static int func(int now) {
		if(parent[now] == now) return now;
		return parent[now] = func(parent[now]);
	}

	static void union(int u, int v) {
		u = func(u);
		v = func(v);
		if(u != v) {
			if(u < v) parent[v] = u;
			else parent[u] = v;
		}
	}
}