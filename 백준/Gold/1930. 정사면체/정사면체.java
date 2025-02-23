import java.io.*;
import java.util.*;

public class Main {
	static int[] tetra;
	static int[] compare;
	static HashMap<Integer, Integer> map1;
	static HashMap<Integer, Integer> map2;
	static HashSet<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(K-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tetra = new int[4];
			compare = new int[4];
			map1 = new HashMap<>();
			map2 = new HashMap<>();
			set = new HashSet<>();
			for(int i=0; i<4; i++) {
				tetra[i] = Integer.parseInt(st.nextToken());
				map1.put(tetra[i], map1.getOrDefault(tetra[i], 0)+1);
			}
			for(int i=0; i<4; i++) {
				compare[i] = Integer.parseInt(st.nextToken());
				map2.put(compare[i], map2.getOrDefault(compare[i], 0)+1);
			}
			if(!isHavingNumber()) {
				sb.append(0).append('\n');
				continue;
			}
			rotation(tetra[0], tetra[1], tetra[2]);
			rotation(tetra[3], tetra[2], tetra[1]);
			rotation(tetra[3], tetra[1], tetra[0]);
			rotation(tetra[3], tetra[0], tetra[2]);
			StringBuilder sb2 = new StringBuilder();
			sb2.append(compare[0]).append(compare[1]).append(compare[2]);
			if(!set.contains(sb2.toString())) {
				sb.append(0).append('\n');
			}
			else {
				sb.append(1).append('\n');
			}
		}
		System.out.println(sb);
	}
	static boolean isHavingNumber() {
		for(int idx : map1.keySet()) {
			int num = map1.get(idx);
			if(!map2.containsKey(idx) || map2.get(idx) != num) return false;
		}
		return true;
	}

	static void rotation(int start, int mid, int end) {
		StringBuilder sb = new StringBuilder();
		sb.append(start).append(mid).append(end);
		set.add(sb.toString());
		sb.setLength(0);
		sb.append(mid).append(end).append(start);
		set.add(sb.toString());
		sb.setLength(0);
		sb.append(end).append(start).append(mid);
		set.add(sb.toString());
		sb.setLength(0);
	}
}