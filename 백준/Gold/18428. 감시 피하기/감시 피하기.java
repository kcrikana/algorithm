import java.util.*;
import java.io.*;
public class Main {

	static char[][] corridor;
	static ArrayList<int[]> students;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		corridor = new char[N][N];
		students = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				corridor[i][j] = str.charAt(j*2);
				if(corridor[i][j] == 'S') students.add(new int[]{i, j});
			}
		}
		if (dfs(0, 0)) System.out.println("YES");
		else System.out.println("NO");

	}

	static boolean dfs(int depth, int count) {
		if(count == 3) {
			return check();
		}
		if(depth == N*N-1) return false;
		for(int i=depth; i<(N*N); i++) {
			int row = i/N;
			int col = i%N;
			if(corridor[row][col] == 'X') {
				corridor[row][col] = 'O';
				if(dfs(depth+1, count+1)) return true;
				corridor[row][col] = 'X';
			}
		}
		return false;
	}

	static boolean check() {
		for(int[] student : students) {
			int row = student[0];
			int col = student[1];
			for(int i=row-1; i>0; i--) {
				 if(corridor[i][col] == 'O' || corridor[i][col] == 'S') break;
				 if(corridor[i][col] == 'T') return false;
			}
			for(int i=row+1; i<N; i++) {
				if(corridor[i][col] == 'O' || corridor[i][col] == 'S') break;
				if(corridor[i][col] == 'T') return false;
			}
			for(int i=col-1; i>0; i--) {
				if(corridor[row][i] == 'O' || corridor[row][i] == 'S') break;
				if(corridor[row][i] == 'T') return false;
			}
			for(int i=col+1; i<N; i++) {
				if(corridor[row][i] == 'O' || corridor[row][i] == 'S') break;
				if(corridor[row][i] == 'T') return false;
			}
		}
		return true;
	}
}