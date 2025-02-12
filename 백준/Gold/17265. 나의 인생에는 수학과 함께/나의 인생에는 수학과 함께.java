import java.io.*;
import java.util.*;
public class Main {
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	static int N;
	static char[][] arr;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static char[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		list = new char[N*2-1];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j*2);
			}
		}
		list[0] = arr[0][0];
		dfs(0,0, 1);
		StringBuilder sb = new StringBuilder();
		sb.append(max).append(' ').append(min);
		System.out.println(sb);
	}

	static void dfs(int row, int col, int depth) {
		if(row == N-1 && col == N-1) {
			int result = calc();
			max = Math.max(result, max);
			min = Math.min(result, min);
			return;
		}
		for(int i=0; i<2; i++) {
			int dRow = dr[i] + row;
			int dCol = dc[i] + col;
			if(dRow >= N || dCol >=N) continue;
			list[depth] = arr[dRow][dCol];
			dfs(dRow, dCol, depth+1);
		}
	}

	static int calc() {
		int num1 = list[0]-'0';
		int num2 = 0;
		char operator = ' ';
		 for(int i=1; i<N*2-1; i++) {
			 if(i%2 == 0) {
				num2 = list[i]-'0';
				if(operator == '+') num1 += num2;
				else if(operator == '*') num1 *= num2;
				else if(operator == '-') num1 -= num2;
			 }
			 else operator = list[i];
		 }
		return num1;
	}
}