import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int result = 0;
		int[] arrow = new int[1000001];
		for(int b : arr) {
			if(arrow[b] == 0) {
				result++;
				arrow[b-1]++;
			}
			else {
				arrow[b]--;
				arrow[b-1]++;

			}
		}
		System.out.println(result);

	}
}