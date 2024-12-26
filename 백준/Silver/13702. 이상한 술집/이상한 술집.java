import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		long start = 1;
		long end = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			end += arr[i];
		}
		while(start <= end) {
			long mid = (start+end)/2;
			long count = 0;
			for(int i=0; i<N; i++) count += arr[i]/mid;
			if(count < K) end = mid - 1;
			else start = mid + 1;
		}
		System.out.println(end);
	}
}