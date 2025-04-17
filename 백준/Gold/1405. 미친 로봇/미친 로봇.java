import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static double[] pos;  // 동 서 남 북
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static boolean[][] visited;
	static double result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		pos = new double[4];
		visited = new boolean[30][30];
		visited[15][15] = true;
		for(int i=0; i<4; i++) pos[i] = Double.parseDouble(st.nextToken())*0.01;
		dfs(15,15, 0,1);
		System.out.println(result);
	}

	static void dfs(int row, int col, int count, double percent) {
		if(count == N) {
			result += percent;
			return;
		}
		for(int i=0; i<4; i++) {
			int dRow = dr[i] + row;
			int dCol = dc[i] + col;
			if(dRow <= 0 || dCol <= 0 || dRow >= 30 || dCol >= 30) continue;
			if(!visited[dRow][dCol]) {
				visited[dRow][dCol] = true;
				dfs(dRow, dCol, count+1, percent*pos[i]);
				visited[dRow][dCol] = false;
			}
		}
	}
}