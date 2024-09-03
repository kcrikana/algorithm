import java.util.*;

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public int solution(int[][] board) {
        int result = Integer.MAX_VALUE;
        int N = board.length;
        int[][][] visit = new int[N][N][4];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,0,1));
        q.offer(new Node(0,0,0,2));
        for(int i=0; i<4; i++) {
            visit[0][0][i] = 0;
        }
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.row == N-1 && now.col == N-1) {
                result = Math.min(result, visit[N-1][N-1][now.direction]);
                continue;
            }
            for(int i=0; i<4; i++) {
                int dRow = now.row + dr[i];
                int dCol = now.col + dc[i];
                if(dRow < 0 || dCol < 0 || dRow >= N || dCol >= N || board[dRow][dCol] == 1) continue;
                int nextCost = now.cost+100;
                if(now.direction != i) nextCost += 500;
                if(nextCost <= visit[dRow][dCol][i]) {
                    visit[dRow][dCol][i] = nextCost;
                    q.offer(new Node(dRow, dCol, visit[dRow][dCol][i], i));
                }
            }
        }
        return result;
    }
}

class Node {
    int row, col, cost, direction;
    public Node(int row, int col, int cost, int direction) {
        this.row = row;
        this.col = col;
        this.cost = cost;
        this.direction = direction;
    }

}
