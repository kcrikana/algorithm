import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		int[][] boxes = new int[N][M+1];
		boolean[] visited = new boolean[M+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) boxes[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int joker=0; joker<N; joker++) {
			visited = new boolean[M+1];
			int count = 0;
			for(int i=0; i<N; i++) {
				if(joker != i) {
					int flag = 0;
					for(int j=1; j<=M; j++) {
						if(boxes[i][j] != 0) flag++;
					}
					if(flag == 0) continue;
					if(flag == 1) {
						int color = 0;
						for(int j=1; j<=M; j++) {
							if(boxes[i][j] > 0) color = j;
						}
						if(visited[color]) count++;
						else visited[color] = true;
					}
					else if(flag > 1) count++;
				}
			}
			min = Math.min(min, count);
		}
		System.out.println(min);
	}
}