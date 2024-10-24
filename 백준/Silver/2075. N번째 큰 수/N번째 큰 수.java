import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0; j<N; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		int count = 1;
		int num = 0;
		while(count++ <= N) {
			num = pq.poll();
		}
		System.out.println(num);
	}
}