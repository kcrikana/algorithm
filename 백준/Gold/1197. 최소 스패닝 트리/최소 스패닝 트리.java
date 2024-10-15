import java.util.*;
import java.io.*;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] edges = new int[E][3];
		p = new int[V+1];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(bf.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<V+1; i++) {
			p[i] = i;
		}
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		int sum = 0;
		int count = 0;
		for(int i=0; i<E; i++) {
			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);
			if(px != py) {
				sum += edges[i][2];
				count++;
				union(px, py);
			}
			if(count == V-1) break;
		}
		System.out.println(sum);
	}

	static int findset(int x) {
		if (x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}

	static void union(int x, int y) {
		p[y] = x;
	}
}