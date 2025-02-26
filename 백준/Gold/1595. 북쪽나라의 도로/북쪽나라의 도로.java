import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Node>[] list;
	static boolean[] visited;
	static long max = -1;
	static int node;
	public static void main(String[] args) throws IOException {
		list = new ArrayList[10001];
		visited = new boolean[10001];
		for(int i=0; i<=10000; i++) list[i] = new ArrayList<>();
		boolean isTruth = false;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String str;
			StringTokenizer st;
			while(!(str = br.readLine()).isEmpty()) {
				st = new StringTokenizer(str);
				int idx1 = Integer.parseInt(st.nextToken());
				int idx2 = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				isTruth = true;
				list[idx1].add(new Node(idx2, dist));
				list[idx2].add(new Node(idx1, dist));
			}
		} catch (Exception e) {}
		if(!isTruth) {
			System.out.println(0);
			return;
		}
		visited[1] = true;
		dfs(1, 0);
		Arrays.fill(visited, false);
		visited[node] = true;
		max = -1;
		dfs(node, 0);
		System.out.println(max);
	}

	static void dfs(int now, long cost) {
		for(Node next : list[now]) {
			if(visited[next.idx]) continue;
			long nextDist = cost + next.dist;
			visited[next.idx] = true;
			if(max < nextDist) {
				node = next.idx;
				max = nextDist;
			}
			dfs(next.idx, nextDist);
		}
	}
}

class Node {
	int idx, dist;
	public Node(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}
}