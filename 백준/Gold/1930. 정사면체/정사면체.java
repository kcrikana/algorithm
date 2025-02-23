import java.io.*;
import java.util.*;

public class Main {
	static int[] tetra;
	static int[] compare;
	static HashSet<String> set;
	static int[][] dr= {{0, 1, 2}, {1, 2, 0}, {2, 0, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(K-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tetra = new int[4];
			compare = new int[4];
			set = new HashSet<>();
			for(int i=0; i<4; i++) tetra[i] = Integer.parseInt(st.nextToken());
			for(int i=0; i<4; i++) compare[i] = Integer.parseInt(st.nextToken());
			rotation(new int[]{tetra[0], tetra[1], tetra[2]}, tetra[3]);
			rotation(new int[]{tetra[3], tetra[2], tetra[1]}, tetra[0]);
			rotation(new int[]{tetra[3], tetra[1], tetra[0]}, tetra[2]);
			rotation(new int[]{tetra[3], tetra[0], tetra[2]}, tetra[1]);
			StringBuilder sb2 = new StringBuilder();
			sb2.append(compare[0]).append(compare[1]).append(compare[2]).append(compare[3]);
			if(!set.contains(sb2.toString())) {
				sb.append(0).append('\n');
			}
			else {
				sb.append(1).append('\n');
			}
		}
		System.out.println(sb);
	}

	static void rotation(int[] ra, int bottom) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<3; i++) {
			sb.append(ra[dr[i][0]]).append(ra[dr[i][1]]).append(ra[dr[i][2]]).append(bottom);
			set.add(sb.toString());
			sb.setLength(0);
		}
	}
}