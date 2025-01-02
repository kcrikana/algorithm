import java.io.*;
public class Main {
	static int N;
	static int[] dr = {0, 0, 1};
	static int[] dc = {-1, 1, 0};
	static char[][] cookie;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cookie = new char[N][N];
		int startRow = 0;
		int startCol = 0;
		boolean isStart = false;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				cookie[i][j] = str.charAt(j);
				if(!isStart && cookie[i][j] == '*') {
					startRow = i;
					startCol = j;
					isStart = true;
				}
			}
		}
		startRow++;
		StringBuilder sb = new StringBuilder();
		sb.append(startRow+1).append(' ').append(startCol+1).append('\n');
		int leftArm = searchLength(startRow,startCol-1, 0);
		int rightArm = searchLength(startRow,startCol+1, 1);
		int body = searchLength(startRow+1,startCol, 2);
		int leftLeg = searchLength(startRow+body+1,startCol-1, 2);
		int rightLeg = searchLength(startRow+body+1,startCol+1, 2);
		sb.append(leftArm).append(' ').append(rightArm).append(' ');
		sb.append(body).append(' ').append(leftLeg).append(' ').append(rightLeg);
		System.out.println(sb);
	}

	static int searchLength(int row, int col, int direction) {
		int count = 1;
		while(true) {
			int dRow = row + dr[direction];
			int dCol = col + dc[direction];
			if(dRow < 0 || dCol < 0 || dRow >= N || dCol >= N || cookie[dRow][dCol] == '_') break;
			count++;
			row = dRow;
			col = dCol;
		}
		return count;
	}
}