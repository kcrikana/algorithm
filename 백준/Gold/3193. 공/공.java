import java.io.*;
import java.util.*;

public class Main {
	static int N, targetRow, targetCol;
	static char[][] board;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		board = new char[N][N];
		targetRow = 0;
		targetCol = 0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				board[i][j] = str.charAt(j);
				if(board[i][j] == 'L') {
					targetRow = i;
					targetCol = j;
				}
			}
		}
		int now = 2;
		for(int i=0; i<K; i++) {
			char direction = br.readLine().charAt(0);
			if(direction == 'L') now = (now+1)%4;
			else now = (now+3)%4;
			drop(now);
		}
		StringBuilder sb = new StringBuilder();
		if(now == 2) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) sb.append(board[i][j]);
					sb.append('\n');
			}
		}
		else if(now == 1){
			for(int i=0; i<N; i++) {
				for(int j=N-1; j>=0; j--) sb.append(board[j][i]);
					sb.append('\n');
			}
		}
		else if(now == 0){
			for(int i=N-1; i>=0; i--) {
				for(int j=N-1; j>=0; j--) sb.append(board[i][j]);
				sb.append('\n');
			}
		}
		else{
			for(int i=N-1; i>=0; i--) {
				for(int j=0; j<N; j++) sb.append(board[j][i]);
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
	
	static void drop(int dir) {
		while(true) {
			int dRow = targetRow + dr[dir];
			int dCol = targetCol + dc[dir];
			if(dRow < 0 || dCol < 0 || dRow >= N
				|| dCol >= N || board[dRow][dCol] == 'X') break;
			board[targetRow][targetCol] = '.';
			board[dRow][dCol] = 'L';
			targetRow = dRow;
			targetCol = dCol;
		}
	}
}
