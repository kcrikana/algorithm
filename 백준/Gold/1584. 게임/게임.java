import java.util.*;
import java.io.*;

public class Main {
	static int[][] zone = new int[501][501];
	static int[][] dist = new int[501][501];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j=Math.min(x1, x2); j<= Math.max(x1, x2); j++) {
				for(int k=Math.min(y1, y2); k<=Math.max(y1, y2); k++) {
					zone[j][k] = 1;
				}
			}
		}
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j=Math.min(x1, x2); j<= Math.max(x1, x2); j++) {
				for(int k=Math.min(y1, y2); k<=Math.max(y1, y2); k++) {
					zone[j][k] = -1;
				}
			}
		}
		for(int i=0; i<501; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		dijk();
		System.out.println(dist[500][500] == Integer.MAX_VALUE ? -1 : dist[500][500]);
	}

	static void dijk() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0 ,0));
		dist[0][0] = 0;
		zone[0][0] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(dist[now.row][now.col] < now.cost) continue;
			for(int i=0; i<4; i++) {
				int dRow = dr[i] + now.row;
				int dCol = dc[i] + now.col;
				if(dRow < 0 || dCol < 0 || dRow > 500 || dCol > 500) continue;
				if(zone[dRow][dCol] == -1) continue;
				if(dist[dRow][dCol] > dist[now.row][now.col] + zone[dRow][dCol]) {
					dist[dRow][dCol] = dist[now.row][now.col] + zone[dRow][dCol];
					pq.offer(new Node(dRow, dCol, dist[dRow][dCol]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int row, col, cost;
	public Node(int row, int col, int cost) {
		this.row = row;
		this.col = col;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}