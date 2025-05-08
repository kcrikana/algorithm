import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static long[] dist;
	static final long INF = Long.MAX_VALUE;
	static boolean[] visited;
	static boolean[] bush;
	static ArrayList<Node>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new long[N];
		bush = new boolean[N];  // false가 부쉬인곳
		visited = new boolean[N];
		graph = new ArrayList[N];
		for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 1) bush[i] = true;
		}
		bush[N-1] = false;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, t));
			graph[b].add(new Node(a, t));
		}
		Arrays.fill(dist, INF);
		dist[0] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.idx]) continue;
			visited[now.idx] = true;
			if(now.idx == N-1) {
				System.out.println(dist[now.idx]);
				return;
			}
			for(Node next : graph[now.idx]) {
				if(!bush[next.idx] && dist[next.idx] >= next.time+dist[now.idx]) {
					dist[next.idx] = next.time+dist[now.idx];
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		System.out.println(-1);
	}
}

class Node implements Comparable<Node>{
	int idx;
	long time;
	public Node(int idx, long time) {
		this.idx = idx;
		this.time = time;
	}

	@Override
	public int compareTo(Node o) {
		return Long.compare(this.time, o.time);
	}
}