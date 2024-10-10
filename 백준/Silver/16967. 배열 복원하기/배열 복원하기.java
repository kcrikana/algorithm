import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int[][] A = new int[H][W];
		for(int i=0; i<H+X; i++) {
			st = new StringTokenizer(bf.readLine());
			if(i>=H) continue;
			for(int j=0; j<W; j++) {
				if(i<X && j<W) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
				else if(i>=X){
					if(j<Y) A[i][j] = Integer.parseInt(st.nextToken());
					else A[i][j] = Integer.parseInt(st.nextToken())-A[i-X][j-Y];
				}
				sb.append(A[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}