import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int[] count = new int[5];
			int N = Integer.parseInt(br.readLine());
			count[0] += N/60;
			N%=60;
			if(N <= 35) {
				if(N%10 > 5) {
					count[1] += N/10+1;
					count[4] += 10-N%10;
				}
				else {
					count[1] += N/10;
					count[3] += N%10;
				}
			}
			else {
				count[0]++;
				if(N%10 >= 5) {
					count[2] += 6 - (N/10+1);
					count[4] += 10 - N%10;
				}
				else {
					count[2] += 6 - N/10;
					count[3] += N%10;
				}
			}
			for(int i=0; i<5; i++) sb.append(count[i]).append(' ');
			sb.append('\n');
		}
		System.out.println(sb);
	}
}