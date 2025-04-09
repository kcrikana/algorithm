import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int start = 1;
		int end = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, arr[i]);
		}
		while(start <= end) {
			int mid = (start+end)/2;
			int count = K;
			for(int i=0; i<N; i++) {
				count--;
				if(arr[i] <= mid) count = K;
				else if(count == 0) break;
			}
			if(count == 0) start = mid + 1;
			else end = mid - 1;
		}
		System.out.println(start);
	}
}