import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			map.put(arr[i], 0);
		}
		int idx = 0;
		for(int key : map.keySet()) map.put(key, idx++);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) sb.append(map.get(arr[i])).append(' ');
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}
}