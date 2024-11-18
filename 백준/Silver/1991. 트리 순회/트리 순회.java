import java.io.*;
public class Main {
	static int N;
	static int[][] tree;
	static StringBuilder sb1 = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	static StringBuilder sb3 = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		tree = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = bf.readLine();
			int idx = str.charAt(0) - 'A';
			char ch2 = str.charAt(2);
			char ch3 = str.charAt(4);
			if (ch2 != '.') tree[idx][0] = ch2 - 'A';
			if (ch3 != '.') tree[idx][1] = ch3 - 'A';
		}
		dfs(0);
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb3);
	}

	static void dfs(int idx) {
		sb1.append((char)(idx+'A'));
		if(tree[idx][0] != 0) dfs(tree[idx][0]);
		sb2.append((char)(idx+'A'));
		if(tree[idx][1] != 0) dfs(tree[idx][1]);
		sb3.append((char)(idx+'A'));
	}
}