import java.util.*;
import java.io.*;
public class Main {

	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		}
		int count = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(count-->0) {
			st = new StringTokenizer(br.readLine());
			int startRow = Integer.parseInt(st.nextToken());
			int startCol = Integer.parseInt(st.nextToken());
			int endRow = Integer.parseInt(st.nextToken());
			int endCol = Integer.parseInt(st.nextToken());
			sb.append(areaSum(startRow,startCol,endRow,endCol)).append('\n');
		}
		System.out.println(sb);
	}

	static int areaSum(int startRow, int startCol, int endRow, int endCol) {
		return arr[endRow][endCol] - arr[endRow][startCol-1] - arr[startRow-1][endCol] + arr[startRow-1][startCol-1];
	}
}