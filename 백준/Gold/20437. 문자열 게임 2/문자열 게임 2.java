import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	static String W;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			W = br.readLine();
			K = Integer.parseInt(br.readLine());
			if(K == 1) {
				sb.append(1).append(' ').append(1).append('\n');
				continue;
			}
			int[] word = new int[26];
            int len = W.length();
			for(int i=0; i<len; i++) word[W.charAt(i)-'a']++;
			int three = Integer.MAX_VALUE;
			int four = -1;
			for(int i=0; i<len; i++) {
				if(word[W.charAt(i)-'a'] < K) continue;
				int count = 1;
				for(int j=i+1; j<len; j++) {
					if(W.charAt(i) == W.charAt(j)) count++;
					if(count == K) {
						three = Math.min(three, j-i+1);
						four = Math.max(four, j-i+1);
						break;
					}
				}
			}
			if(three == Integer.MAX_VALUE || four == -1) sb.append(-1).append('\n');
			else sb.append(three).append(' ').append(four).append('\n');
		}
		System.out.println(sb);
	}
}