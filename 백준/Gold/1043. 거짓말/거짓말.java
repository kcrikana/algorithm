import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] parent;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		list = new ArrayList[M+1];
		for(int i=0; i<=M; i++) list[i] = new ArrayList<>();
		for(int i=0; i<=N; i++) parent[i] = i;
		st = new StringTokenizer(bf.readLine());
		int personCount = Integer.parseInt(st.nextToken());
		int startIdx = 0;
		if(personCount == 0) {
			System.out.println(M);
			return;
		}
		for(int i=0; i<personCount; i++) {
			if(i == 0) startIdx = Integer.parseInt(st.nextToken());
			else {
				int idx = Integer.parseInt(st.nextToken());
				if(findSet(idx) != findSet(startIdx)) union(startIdx,idx);
			}
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int partyPerson = Integer.parseInt(st.nextToken());
			int startNum = Integer.parseInt(st.nextToken());
			list[i].add(startNum);
			for(int j=1; j<partyPerson; j++) {
				int idx = Integer.parseInt(st.nextToken());
				list[i].add(idx);
				if(findSet(idx) != findSet(startNum)) union(startNum,idx);
			}
		}
		findSet(startIdx);
		int count = 0;
		for(int i=0; i<M; i++) {
			boolean isTruth = true;
			for(int num : list[i]) {
				if(parent[startIdx] == findSet(num)) {
					isTruth = false;
					break;
				}
			}
			if(isTruth) count++;
		}
		System.out.println(count);
	}

	static int findSet(int now) {
		if(now == parent[now]) return now;
		return parent[now] = findSet(parent[now]);
	}

	static void union(int x, int  y) {
		x = findSet(x);
		y = findSet(y);
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
}