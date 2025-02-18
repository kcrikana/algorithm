import java.io.*;
import java.util.*;

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
			for(int i=0; i<26; i++) {
				if(word[i] < K) continue;
				int left = 0;
				int right = 0;
				Queue<Integer> idxList = new LinkedList<>();
				for(int j=0; j<len; j++) {
					if(W.charAt(j)-'a' == i) {
						left = j;
						right = j;
						break;
					}
				}
				while(right < len) {
					if(W.charAt(right)-'a' == i) {
						idxList.add(right);
						if(idxList.size() == K) {
							three = Math.min(three, right-left+1);
							four = Math.max(four, right-left+1);
							idxList.poll();
							left = idxList.peek();
						}
					}
					right++;
				}
			}
			if(three == Integer.MAX_VALUE || four == -1) sb.append(-1).append('\n');
			else sb.append(three).append(' ').append(four).append('\n');
		}
		System.out.println(sb);
	}
}