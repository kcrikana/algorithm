import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ans = 0;
		int startNum = 1;
		startNum |=  1 << ('c'-'a');
		startNum |=  1 << ('t'-'a');
		startNum |=  1 << ('i'-'a');
		startNum |=  1 << ('n'-'a');
		if(K < 5) {
			System.out.println(0);
			return;
		}
		else if(K == 26) {
			System.out.println(N);
			return;
		}

		for(int i=0; i<N; i++) {
			for(char ch : br.readLine().toCharArray()) {
				arr[i] |= 1 << (ch-'a');
			}
		}
		backTracking(0, 0, startNum);
		System.out.println(ans);
	}

	static void backTracking(int depth, int select, int now) {
		if(select == K-5) {
			int count = 0;
			for(int i=0; i<N; i++) {
				if((now & arr[i]) == arr[i]) count++;
			}
			ans = Math.max(count, ans);
			return;
		}
		for(int i=depth; i<26; i++) {
			if((now & (1 << i)) == 0) backTracking(i+1, select+1, now | 1 << i);
		}
	}
}