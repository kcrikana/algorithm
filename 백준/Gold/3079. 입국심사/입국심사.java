import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		long start = 0;
		long end = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, arr[i]);
		}
		Arrays.sort(arr);
		end *= M;
		while(start <= end) {
			long mid = (start + end)/2;
			long sum = 0;
			for(int now : arr) {
				long count = mid/now;
				if(sum >= M) break;
				sum += count;
			}
			if(sum >= M) end = mid - 1;
			else start = mid + 1;
		}
		System.out.println(start);
	}
}