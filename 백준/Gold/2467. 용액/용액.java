import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = arr.length-1;
		int firstIdx = 0;
		int secondIdx = arr.length-1;
		long nearZeroSum = Long.MAX_VALUE;
		while(start < end) {
			long sum  = arr[start] + arr[end];
			long absSum = Math.abs(sum);
			if(nearZeroSum > absSum) {
				nearZeroSum = absSum;
				firstIdx = start;
				secondIdx = end;
			}
			if(sum > 0) end--;
			else start++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(arr[firstIdx]).append(' ').append(arr[secondIdx]);
		System.out.println(sb);
	}
}