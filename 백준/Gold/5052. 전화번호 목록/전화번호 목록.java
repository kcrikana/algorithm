import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine();
			}
			Arrays.sort(arr);
			if(trie(arr)) sb.append("YES").append('\n');
			else sb.append("NO").append('\n');
		}
		System.out.println(sb);
	}

	static boolean trie(String[] arr) {
		for(int i=0; i<N-1; i++) {
			if(arr[i+1].startsWith(arr[i])) return false;
		}
		return true;
	}
}
