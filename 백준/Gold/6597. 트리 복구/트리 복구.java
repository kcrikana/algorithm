import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	static char[] pre, in;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true)  {
			String str = br.readLine();
			if(str == null) break;
			st = new StringTokenizer(str);
			pre = st.nextToken().toCharArray();
			in = st.nextToken().toCharArray();
			postOrder(0, 0, in.length);
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static void postOrder(int root, int start, int end) {
		if(root >= pre.length) return;
		for(int i=start; i<end; i++) {
			if(in[i] == pre[root]) {
				postOrder(root+1, start, i);
				postOrder(root+(i+1-start), i+1, end);
				sb.append(pre[root]);
				return;
			}
		}
	}
}