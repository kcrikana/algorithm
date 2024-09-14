import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static int[][] arr;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = bf.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		int num = dijk();
		System.out.println(num);
	}
	static int dijk() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0,0));
		int[][] dist = new int[n][n];
		int INF = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) Arrays.fill(dist[i], INF);

		dist[0][0] = 0;
		int ans = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.row == n-1 && now.col == n-1) {
				ans = now.cost;
				break;
			}
			for(int i=0; i<4; i++) {
				int dRow = now.row + dr[i];
				int dCol = now.col + dc[i];
				if(dRow >= n || dCol >= n || dRow < 0 || dCol < 0) continue;
				int nextCost = now.cost;
				if(arr[dRow][dCol] == 0) nextCost++;
				if(dist[dRow][dCol] > nextCost) {
					dist[dRow][dCol] = nextCost;
					pq.offer(new Node(dRow, dCol, nextCost));
				}
			}
		}
		return ans;
	}


	static class Node implements Comparable<Node> {
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
}