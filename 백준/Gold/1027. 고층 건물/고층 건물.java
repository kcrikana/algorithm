import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		int[] count = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			double slope = 0;
			for(int j=i-1; j>=0; j--) {
				double now = (double)(arr[i]-arr[j])/(i-j);
				if(j == i-1 || slope > now) {
					slope = now;
					count[i]++;
					count[j]++;
				}
			}
		}
		int max = 0;
		for(int i=0; i<N; i++) max = Math.max(count[i],max);
		System.out.println(max);
	}
}