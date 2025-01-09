import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 0;
		while(N > K) {
			int count = -1;
			while(Math.pow(2, count+1) < N) count++;
			if(K == 1) {
				answer += Math.pow(2, count+1)-N;
				break;
			}
			N -= Math.pow(2, count);
			K--;
		}
		System.out.println(answer);
	}
}