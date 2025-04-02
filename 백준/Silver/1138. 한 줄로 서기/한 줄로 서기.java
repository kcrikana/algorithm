import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		Arrays.fill(arr, -1);
		for(int i=1; i<=N; i++) {
			int count = Integer.parseInt(st.nextToken());
			for(int j=0; j<N; j++) {
				if(arr[j] == -1) {
					if(count == 0) {
						arr[j] = i;
						break;
					}
					count--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) sb.append(arr[i]).append(' ');
		System.out.println(sb);
	}
}
