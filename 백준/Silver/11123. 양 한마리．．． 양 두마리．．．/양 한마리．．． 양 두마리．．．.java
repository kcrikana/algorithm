import java.io.*;
import java.util.*;
public class Main {
	static int H, W;
	static char[][] sheep;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			sheep = new char[H][W];
			visited = new boolean[H][W];
			for(int i=0; i<H; i++) {
				String str = br.readLine();
				for(int j=0; j<W; j++) sheep[i][j] = str.charAt(j);
			}
			int count = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(sheep[i][j] == '#' && !visited[i][j]) {
						count++;
						bfs(i,j);
					}
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	static void bfs(int startRow, int startCol) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(startRow, startCol));
		visited[startRow][startCol] = true;
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int i=0; i<4; i++) {
				int dRow = dr[i] + now.row;
				int dCol = dc[i] + now.col;
				if(dRow < 0 || dCol < 0 || dRow >= H || dCol >= W
				|| visited[dRow][dCol] || sheep[dRow][dCol] != '#') continue;
				visited[dRow][dCol] = true;
				q.offer(new Node(dRow,dCol));
			}
		}
	}
}
class Node {
	int row, col;
	Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
