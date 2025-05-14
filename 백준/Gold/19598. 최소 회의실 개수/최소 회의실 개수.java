import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st;
		Node[] arr = new Node[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i] = new Node(start, end);
		}
		Arrays.sort(arr);
		int ans = 0;
		pq.offer(arr[0].end);
		for(int i=1; i<N; i++) {
			if(arr[i].start >= pq.peek()) pq.poll();
			pq.offer(arr[i].end);
			ans = Math.max(pq.size(), ans);
		}
		System.out.println(ans);
	}
}


class Node implements Comparable<Node>{
	int start, end;
	public Node(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Node o) {
		if(this.start != o.start) return this.start - o.start;
		return this.end - o.end;
	}
}