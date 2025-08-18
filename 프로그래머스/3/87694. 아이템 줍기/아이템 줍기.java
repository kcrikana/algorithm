import java.util.*;
class Solution {
    int[][] arr;
    boolean[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        arr = new int[101][101];
        visited = new boolean[101][101];
        for(int[] coordinates : rectangle) {
            int lowX = coordinates[0]*2;
            int lowY = coordinates[1]*2;
            int highX = coordinates[2]*2;
            int highY = coordinates[3]*2;
            for(int i=lowX; i<=highX; i++) {
                arr[lowY][i] = 1;
                arr[highY][i] = 1;
            }
            for(int i=lowY; i<=highY; i++) {
                arr[i][lowX] = 1;
                arr[i][highX] = 1;
            }
        }
        for(int[] coordinates : rectangle) {
            int lowX = coordinates[0]*2;
            int lowY = coordinates[1]*2;
            int highX = coordinates[2]*2;
            int highY = coordinates[3]*2;
            for(int i=lowY+1; i<=highY-1; i++) {
                for(int j=lowX+1; j<=highX-1; j++) {
                    arr[i][j] = 2;     
                }
            }
        }
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2)/2;
    }
    
    int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(characterY, characterX, 0));
        visited[characterY][characterX] = true;
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.row == itemY && now.col == itemX) return now.dist;
            for(int i=0; i<4; i++) {
                int dRow = dr[i] + now.row;
                int dCol = dc[i] + now.col;
                if(dRow < 0 || dCol < 0 || dRow >= 101 || dCol >= 101 || visited[dRow][dCol]) continue;
                if(arr[dRow][dCol] == 1) {
                    q.offer(new Node(dRow, dCol, now.dist+1));
                    visited[dRow][dCol] = true;
                }
                
            }
            
        }
        return -1;
        
    }
}

class Node {
    int row, col, dist;
    public Node(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}