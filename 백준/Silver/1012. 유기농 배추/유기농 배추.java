import java.util.*;
import java.io.*;

public class Main {

	static int M, N, K;
	static int[][] arr;
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1 ,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			int count = 0;
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				arr[Y][X] = 1;
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] == 1) {
						count++;
						bfs(i,j);
					}
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	static void bfs(int startRow, int startCol) {
		Queue<int[]> q = new LinkedList<>();
		arr[startRow][startCol] = 2;
		q.offer(new int[]{startRow,startCol});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0; i<4; i++) {
				int dRow = now[0]+dr[i];
				int dCol = now[1]+dc[i];
				if(dRow < 0 || dCol < 0 || dRow >= N || dCol >= M || arr[dRow][dCol] != 1) continue;
				arr[dRow][dCol] = 2;
				q.offer(new int[]{dRow, dCol});
			}
		}
	}
}
