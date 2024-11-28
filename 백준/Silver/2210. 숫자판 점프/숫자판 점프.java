import java.io.*;
import java.util.*;

public class Main {
	static char[][] arr;
	static HashSet<String> set = new HashSet<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		for(int i=0; i<5; i++) {
			String str = bf.readLine();
			for(int j=0; j<5; j++) arr[i][j] = str.charAt(j*2);
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				dfs(i,j,0, "");
			}
		}
		System.out.println(set.size());
	}
	static void dfs(int startRow, int startCol, int count, String str) {
		str += arr[startRow][startCol];
		if(count == 5) {
			set.add(str);
			return;
		}
		for(int i=0; i<4; i++) {
			int dRow = startRow + dr[i];
			int dCol = startCol + dc[i];
			if(dRow < 0 || dCol < 0 || dRow >= 5 || dCol >= 5) continue;
			dfs(dRow, dCol, count+1, str);
		}
	}
}