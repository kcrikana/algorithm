import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    char[][] alphabet;
    int n, m;
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        int answer = n*m;
        alphabet = new char[n+2][m+2];
        for(int i=0; i<=n+1; i++) Arrays.fill(alphabet[i], ' ');
        for(int i=0; i<n; i++) {
            String str = storage[i];
            for(int j=0; j<m; j++) {
                alphabet[i+1][j+1] = str.charAt(j);
            }
        }
        
        for(String request : requests) {
            if(request.length() == 1) answer -= bfs(request.charAt(0));
            else {
                char ch = request.charAt(0);
                for(int i=1; i<=n; i++) {
                    for(int j=0; j<=m; j++) if(alphabet[i][j] == ch) {
                        alphabet[i][j] = ' ';
                        answer--;
                    }
                }
            }
        }
        return answer;
    }
    
    int bfs(char ch) {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n+2][m+2];
        visited[0][0] = true;
        q.offer(new Node(0, 0));
        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int i=0; i<4; i++) {
                int dRow = now.row + dr[i];
                int dCol = now.col + dc[i];
                if(dRow < 0 || dCol < 0 || dRow >= n+2 || dCol >= m+2 
                   || visited[dRow][dCol]) continue;
                if(alphabet[dRow][dCol] == ' ') {
                    visited[dRow][dCol] = true;
                    q.offer(new Node(dRow, dCol));
                }
                else if(alphabet[dRow][dCol] == ch) {
                    visited[dRow][dCol] = true;
                    count++;
                    alphabet[dRow][dCol] = ' ';
                    
                }
            }
        }
        return count;
    }
}

class Node {
    int row, col;
    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }  
}