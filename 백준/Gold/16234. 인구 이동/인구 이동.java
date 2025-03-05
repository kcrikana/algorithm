import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Node> list = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		boolean isTruth = false;
		while(true) {
			isTruth = false;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					if(bfs(i,j)) isTruth = true;
				}
			}
			if (!isTruth) {
				System.out.println(result);
				return;
			}
			result++;
		}
	}

	static boolean bfs(int startRow, int startCol) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(startRow, startCol));
		list.add(new Node(startRow, startCol));
		boolean isTruth = false;
		visited[startRow][startCol] = true;
		int sum = arr[startRow][startCol];
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int i=0; i<4; i++) {
				int dRow = now.row + dr[i];
				int dCol = now.col + dc[i];
				if(dRow < 0 || dCol < 0 || dRow >= N || dCol >= N || visited[dRow][dCol]) continue;
				int diff = Math.abs(arr[now.row][now.col]-arr[dRow][dCol]);
				if(diff >= L && diff <= R) {
					visited[dRow][dCol] = true;
					q.offer(new Node(dRow, dCol));
					list.add(new Node(dRow, dCol));
					sum += arr[dRow][dCol];
					isTruth = true;
				}
			}
		}
		int avg = sum / list.size();
		while(!list.isEmpty()) {
			Node now = list.poll();
			arr[now.row][now.col] = avg;
		}
		return isTruth;
	}
}

class Node {
	int row, col;
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
}