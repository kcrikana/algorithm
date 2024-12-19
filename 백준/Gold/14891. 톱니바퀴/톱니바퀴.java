import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] wheel;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wheel = new ArrayList[4];
		for(int i=0; i<4; i++) wheel[i] = new ArrayList<>();
		for(int i=0; i<4; i++)
			for(char ch : br.readLine().toCharArray()) wheel[i].add(ch-'0');
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken())-1;
			int direction = Integer.parseInt(st.nextToken());
			visit = new boolean[4];
			rotation(idx, direction);
		}
		int result = 0;
		if(wheel[0].get(0) == 1) result += 1;
		if(wheel[1].get(0) == 1) result += 2;
		if(wheel[2].get(0) == 1) result += 4;
		if(wheel[3].get(0) == 1) result += 8;
		System.out.println(result);
	}

	static void rotation(int now, int direction) {
		visit[now] = true;
		int past = now-1;
		int next = now+1;
		int contray = direction == -1 ? 1 : -1;
		if(past >= 0 && !visit[past] && wheel[past].get(2) != wheel[now].get(6)) rotation(past, contray);
		if(next < 4 && !visit[next] && wheel[now].get(2) != wheel[next].get(6)) rotation(next, contray);
		if(direction == 1) {
			int temp = wheel[now].remove(7);
			wheel[now].add(0, temp);
		}
		else {
			int temp = wheel[now].remove(0);
			wheel[now].add(temp);
		}
	}
}