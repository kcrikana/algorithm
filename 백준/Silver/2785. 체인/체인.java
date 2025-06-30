import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] chains = new int[N];
		for(int i=0; i<N; i++) chains[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(chains);
		int count = 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
			count = N-1-i;
			sum += chains[i];
			if(sum >= count) break;
		}
		System.out.println(count);
	}
}