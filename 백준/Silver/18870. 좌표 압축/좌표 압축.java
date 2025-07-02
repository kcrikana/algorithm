import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] origin = new int[N];
		int[] sorted = new int[N];
		HashMap<Integer, Integer> rankingMap = new HashMap<>();

		for(int i = 0; i < N; i++) {
			sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sorted);

		int rank = 0;
		for(int v : sorted) {
			if(!rankingMap.containsKey(v)) {
				rankingMap.put(v, rank);
				rank++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int key : origin) {
			sb.append(rankingMap.get(key)).append(' ');
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}
}