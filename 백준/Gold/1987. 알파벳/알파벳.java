import java.io.*;
import java.util.*;
public class Main {
	static int R, C, ans;
	static char[][] arr;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static int num = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for(int i=0; i<R; i++) arr[i] = br.readLine().toCharArray();
		num += 1 << (arr[0][0]-'A');
		ans = 0;
		dfs(0,0);
		System.out.println(ans);
	}

	static void dfs(int row, int col) {
		ans = Math.max(ans, Integer.bitCount(num));
		for(int i=0; i<4; i++) {
			int dRow = dr[i] + row;
			int dCol = dc[i] + col;
			if(dRow < 0 || dCol < 0 || dRow >= R || dCol >= C || (num & 1 << (arr[dRow][dCol]-'A')) != 0) continue;
			int now = 1 << (arr[dRow][dCol]-'A');
			num += now;
			dfs(dRow, dCol);
			num -= now;
		}
	}
}