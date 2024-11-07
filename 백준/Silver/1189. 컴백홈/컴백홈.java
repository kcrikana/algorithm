import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int endRow, endCol;
	static int R,C,K,ans;

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static char[][] arr;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int startRow = R-1;
		int startCol = 0;
		ans = 0;
		endRow = 0;
		endCol = C-1;
		arr = new char[R][C];
		visit = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String str = bf.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		visit[startRow][startCol] = true;
		dfs(startRow,startCol, 1);
		System.out.println(ans);
	}

	static void dfs(int startRow, int startCol, int dist) {
		if(startRow == endRow && startCol == endCol && dist == K) {
			ans++;
			return;
		}
		for(int i=0; i<4; i++) {
			int dRow = dr[i] + startRow;
			int dCol = dc[i] + startCol;
			if(dRow < 0 || dCol < 0 || dRow >= R || dCol >= C || visit[dRow][dCol]) continue;
			if(arr[dRow][dCol] == 'T') continue;
			visit[dRow][dCol] = true;
			dfs(dRow, dCol, dist+1);
			visit[dRow][dCol] = false;
		}
		return;
	}
}