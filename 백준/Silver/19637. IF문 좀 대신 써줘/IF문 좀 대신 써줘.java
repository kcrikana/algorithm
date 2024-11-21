import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static String[] medal;
	static int[] cost;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		medal = new String[N];
		cost = new int[N];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			medal[i] = st.nextToken();
			cost[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(bf.readLine());
			sb.append(func(num)).append('\n');
		}
		System.out.println(sb);
	}

	static String func(int power) {
		int start = 0;
		int end = N-1;
		while(start <= end) {
			int mid = (start+end)/2;
			int midCost = cost[mid];
			if(midCost < power) start = mid + 1;
			else end = mid - 1;
		}
		return medal[start];
	}
}