import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] arr = new int[N+1];
		Stack<Integer> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i == 1) {
				sb.append(0).append(' ');
				stk.push(i);
			}
			else {
				while(!stk.isEmpty()) {
					int num = arr[stk.peek()];
					if(num >= arr[i]) {
						sb.append(stk.peek()).append(' ');
						stk.push(i);
						break;
					}
					else stk.pop();
				}
				if(stk.isEmpty()) {
					sb.append(0).append(' ');
					stk.push(i);
				}
			}
		}
		System.out.println(sb);
	}
}