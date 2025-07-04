import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static ArrayList<String> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		backTracking(0, 1);
		for(String str : list) sb.append(str).append('\n');
		System.out.println(sb);
	}

	static void backTracking(int depth, int lastNum) {
		if(depth == M) {
			for(int i=0; i<M; i++) sb.append(arr[i]).append(' ');
			sb.delete(M*2-1, M*2);
			list.add(sb.toString());
			sb.setLength(0);
			return;
		}
		for(int i=lastNum; i<=N; i++) {
			arr[depth] = i;
			backTracking(depth+1, i+1);
		}
	}
}