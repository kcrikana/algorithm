import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static String answer, result;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		String str = bf.readLine();
		for(int i=0; i<N; i++) {
			sb.append(str.charAt(i*2));
		}
		result = sb.toString();
		sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(i);
		}
		answer = sb.toString();
		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(result, 0));
		HashSet<String> set = new HashSet<>();
		set.add(result);
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(now.str.equals(answer)) return now.count;
			for(int i=0; i<=N-K; i++) {
				char[] arr = now.str.toCharArray();
				for(int j=0; j<K/2; j++) {
					char temp = arr[i+j];
					arr[i+j] = arr[i+K-1-j];
					arr[i+K-1-j] = temp;
				}
				String next = new String(arr);
				if(!set.contains(next)) {
					q.offer(new Node(next,now.count+1));
					set.add(next);
				}
			}
		}
		return -1;
	}

	static class Node {
		String str;
		int count;
		public Node(String str, int count) {
			this.str = str;
			this.count = count;
		}
	}
}