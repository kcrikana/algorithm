import java.util.*;
import java.io.*;
public class Main {
	static int N, M;
	static int[][] graph;
	static int[][] dist;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static Queue<Node> q;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];
		q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph[i][j] = num;
				if(num == 1) {
					dist[i][j] = 0;
					q.offer(new Node(i,j,0));
					visited[i][j] = true;
				}
			}
		}
		bfs();
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) max = Math.max(max, dist[i][j]);
		}
		System.out.println(max);
	}

	static void bfs() {
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int i=0; i<8; i++) {
				int dRow = dr[i] + now.row;
				int dCol = dc[i] + now.col;
				if(dRow < 0 || dCol < 0 || dRow >= N || dCol >= M
					|| visited[dRow][dCol]) continue;
				dist[dRow][dCol] = now.cost+1;
				visited[dRow][dCol] = true;
				q.offer(new Node(dRow, dCol, now.cost+1));
			}
		}
	}
}
class Node {
	int row, col, cost;
	public Node(int row, int col, int cost) {
		this.row = row;
		this.col = col;
		this.cost = cost;
	}
}