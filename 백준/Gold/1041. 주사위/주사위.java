import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[6];
		long max = 0;
		long sum = 0;
		long min = Long.MAX_VALUE;
		long sum2 = Long.MAX_VALUE;
		long sum3 = 0;
		for(int i=0; i<6; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}
		if(N == 1) {
			System.out.println(sum-max);
			return;
		}
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(i + j != 5 && i != j) sum2 = Math.min(sum2, arr[i]+arr[j]);
			}
		}
		for(int i=0; i<3; i++) sum3 += Math.min(arr[i], arr[5-i]);
		long result = sum3*4 + sum2*(4*(N-1)+4*(N-2)) + min*((N-1)*(N-2)*4 + (N-2)*(N-2));
		System.out.println(result);
	}
}