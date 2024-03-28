import java.util.*;
class Solution {
    class Node {
        int row, col, cost;
        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    int[] dr = {0,1,0,-1};
    int[] dc = {1,0,-1,0};
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visit = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,1));
        visit[0][0] = true;
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.row == n-1 && now.col == m-1) return now.cost;
            for(int i=0; i<4; i++) {
                int dRow = now.row+dr[i];
                int dCol = now.col+dc[i];
                if(dRow>=n || dCol>=m || dRow<0 || dCol<0) continue;
                if(visit[dRow][dCol] || maps[dRow][dCol] == 0) continue;
                visit[dRow][dCol] = true;
                q.offer(new Node(dRow, dCol, now.cost+1));
            }
        }
        return -1;
    }
}