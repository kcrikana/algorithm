import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] belt = new int[2*N];
		boolean[] visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2*N; i++) belt[i] = Integer.parseInt(st.nextToken());
		int result = 0;
		while(true) {
			result++;
			int temp = belt[2*N-1];
			for(int i=2*N-1; i>0; i--) belt[i] = belt[i-1];
			belt[0] = temp;
			for(int i=N-1; i>0; i--) visited[i] = visited[i-1];
			visited[0] = false;
			visited[N-1] = false;
			for(int i=N-1; i>0; i--) {
				if(visited[i-1] && !visited[i] && belt[i]>0) {
					visited[i-1] = false;
					visited[i] = true;
					belt[i]--;
					visited[N-1] = false;
				}
			}
			if(belt[0]>0) {
				visited[0] = true;
				belt[0]--;
			}
			int count = 0;
			for(int i=0; i<N*2; i++) if(belt[i] == 0) count++;
			if(count >= K) break;
		}
		System.out.println(result);
	}
}