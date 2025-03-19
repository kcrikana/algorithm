import java.io.*;
import java.util.*;

public class Main {

	static int N, M;

	static char[][] arr;
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[M][N];
		visited = new boolean[M][N];
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) arr[i][j] = str.charAt(j*2);
		}
		visited[0][0] = true;
		bfs();
		if (visited[M - 1][N - 1]) System.out.println("Yes");
		else System.out.println("No");
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		q.offer(0);
		while(!q.isEmpty()) {
			int row = q.poll();
			int col = q.poll();
			if(row == M-1 && col == N-1) return;
			for(int i=0; i<2; i++) {
				int dRow = row + dr[i];
				int dCol = col + dc[i];
				if(dRow < 0 || dCol < 0 || dRow >= M || dCol >= N
					|| visited[dRow][dCol] || arr[dRow][dCol] == '0') continue;
				visited[dRow][dCol] = true;
				q.offer(dRow);
				q.offer(dCol);
			}
		}
	}
}
