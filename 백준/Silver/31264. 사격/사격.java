import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int start = 1;
		int end = arr[N-1];
		long ans = Long.MAX_VALUE;
		while(start <= end) {
			int mid = (start+end)/2;
			if(mid < arr[0]) {
				start = mid + 1;
				continue;
			}
			long sum = 0;
			long skill = mid;
			int idx = 0;
			for(int i=0; i<M; i++) {
				for(int j=idx; j<N; j++) {
					if(skill < arr[j]) {
						idx = j-1;
						break;
					}
				}
				if(skill >= arr[N-1]) idx = N-1;
				sum += arr[idx];
				skill += arr[idx];
			}
			if(sum >= A) {
				ans = Math.min(ans, mid);
				end = mid - 1;
			}
			else start = mid + 1;
		}
		System.out.println(ans);
	}
}