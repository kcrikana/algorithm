import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Integer> deq = new ArrayDeque<>();
		int result = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 1) deq.offerLast(i);
			if(deq.size() == K) {
				result = Math.min(result, deq.peekLast()-deq.peekFirst());
				deq.pollFirst();
			}
		}
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result+1);
	}
}