import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static LinkedList<Node> list = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] examiner = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				examiner[i][j] = Integer.parseInt(st.nextToken());
				list.add(new Node(i,j, examiner[i][j], 0));
			}
		}
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		Collections.sort(list, (o1, o2) -> (o1.virus-o2.virus));
		Queue<Node> q = list;
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(now.time == S) break;
			for(int k=0; k<4; k++) {
				int dRow = dr[k] + now.row;
				int dCol = dc[k] + now.col;
				if(dRow < 0 || dCol < 0 || dRow >= N || dCol >= N
					|| examiner[dRow][dCol] != 0) continue;
				examiner[dRow][dCol] = now.virus;
				q.add(new Node(dRow, dCol, now.virus, now.time+1));
			}
		}
		System.out.println(examiner[X-1][Y-1]);
	}
	static class Node {
		int row, col, virus, time;
		public Node(int row, int col, int virus, int time) {
			this.row = row;
			this.col = col;
			this.virus = virus;
			this.time = time;
		}
	}
}