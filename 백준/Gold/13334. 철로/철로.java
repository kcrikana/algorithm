import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] railway = new Node[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(start > end) railway[i] = new Node(end, start);
			else railway[i] = new Node(start, end);
		}
		int d = Integer.parseInt(br.readLine());
		Arrays.sort(railway);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int result = 0;
		for(Node now : railway) {
			if(now.end - now.start > d) continue;
			pq.offer(now.start);
			while(!pq.isEmpty()) {
				if(now.end-pq.peek() <= d) break;
				pq.poll();
			}
			result = Math.max(result, pq.size());
		}
		System.out.println(result);
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
		return this.end - o.end;
	}
}
