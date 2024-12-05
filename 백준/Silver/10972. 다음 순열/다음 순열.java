import java.io.*;
import java.util.*;
import javax.print.attribute.EnumSyntax;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		if(dfs()) {
			for(int i=0; i<N; i++) sb.append(arr[i]).append(' ');
			System.out.println(sb);
		}
		else System.out.println(-1);
	}

	static boolean dfs() {
		int i = arr.length-1;
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		if(i <= 0) return false;
		int j = arr.length-1;
		while(arr[j] <= arr[i-1]) j--;
		swap(i-1, j);
		j = arr.length-1;
		while(i < j) {
			swap(i, j);
			i++;
			j--;
		}
		return true;
	}

	static void swap(int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}