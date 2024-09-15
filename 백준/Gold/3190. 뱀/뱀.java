import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int K = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(bf.readLine());
			int row = Integer.parseInt(st.nextToken())-1;
			int col = Integer.parseInt(st.nextToken())-1;
			arr[row][col] = 2;              
		}
		int L = Integer.parseInt(bf.readLine());
		int time = 0;
		int nowDirection = 1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(bf.readLine());
			int targetTime = Integer.parseInt(st.nextToken());
			char direct = st.nextToken().charAt(0);
			int num = 0;
			if(direct == 'L') num = -1;
			else num = 1;
			map.put(targetTime,num);
		}
		Deque<Node> q = new LinkedList<>();
		q.offer(new Node(0,0));
		while(true) {
			if(map.containsKey(time)) {
				int num = map.get(time);
				nowDirection = (nowDirection+num+4)%4;
			}
			Node now = q.peekLast();
			int dRow = now.row + dr[nowDirection];
			int dCol = now.col + dc[nowDirection];
			if(dRow < 0 || dCol < 0 || dRow >= N || dCol >= N || arr[dRow][dCol] == 1) break;
			q.offerLast(new Node(dRow, dCol));
			if(arr[dRow][dCol] != 2) {
				Node first = q.pollFirst();
				arr[first.row][first.col] = 0;
			}
			arr[dRow][dCol] = 1;
			time++;
		}
		System.out.println(time+1);
	}

	static class Node {
		int row, col;
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}