import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] timeTable = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			timeTable[i][0] =  Integer.parseInt(st.nextToken());
			timeTable[i][1] =  Integer.parseInt(st.nextToken());
		}
		Arrays.sort(timeTable, (a, b) -> b[1] - a[1]);
		int endTime = timeTable[0][1];

		for(int[] arr : timeTable) {
			if(endTime > arr[1]) endTime = arr[1];
			endTime -= arr[0];
		}
		System.out.println(endTime < 0 ? -1 : endTime);
	}
}