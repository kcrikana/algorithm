import java.util.*;
class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    boolean[][] visited;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int k=0; k<answer.length; k++) {
            answer[k] = check(places[k]) ? 1 : 0;
        }
        return answer;
    }
    
    boolean check(String[] place) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(place[i].charAt(j) == 'P') {
                    visited = new boolean[5][5];
                    visited[i][j] = true;
                    Queue<Node> q = new LinkedList<>();
                    q.offer(new Node(i, j, 2));
                    if(!bfs(q, place)) return false;
                }
            }
        }
        return true;
    }
    
    boolean bfs(Queue<Node> q, String[] place) {
        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int i=0; i<4; i++) {
                int dRow = now.row + dr[i];
                int dCol = now.col + dc[i];
                if(dRow < 0 || dCol < 0 || dRow >= 5 || dCol >= 5 
                   || place[dRow].charAt(dCol) == 'X' || visited[dRow][dCol]) continue;
                if(now.dist > 0) {
                    if(place[dRow].charAt(dCol) == 'P') return false;
                    visited[dRow][dCol] = true;
                    q.offer(new Node(dRow, dCol, now.dist-1));
                }
            }
        }
        return true;
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