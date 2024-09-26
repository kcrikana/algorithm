import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		boolean[][] visit = new boolean[N+1][N+1];
		for(int i=1; i<N; i++) {
			int nodeCount = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0; j<nodeCount; j++) {
				int num = Integer.parseInt(st.nextToken());
				visit[i][num] = true;
			}
		}

		for(int i=1; i<N; i++) {
			for(int j=1; j<N; j++) {
				for(int k=1; k<N; k++) {
					if(visit[j][i] && visit[i][k]) visit[j][k] = true;
				}
			}
		}

		boolean isCycle = false;
		for(int i=1; i<N; i++) {
			if(visit[1][i] && visit[i][i]){
				isCycle = true;
				break;
			}
		}
		System.out.println(isCycle ? "CYCLE" : "NO CYCLE");
	}
}