import java.util.*;

class Solution {
    
    boolean[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    if(picture[i][j] != 0) {
                        numberOfArea++;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(m,n,picture,i,j));
                    }
                } 
            }
        } 
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    int bfs(int m, int n, int[][] picture, int startRow, int startCol) {
        int stand = picture[startRow][startCol];
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        visited[startRow][startCol] = true;
        q.offer(new int[]{startRow, startCol});
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            for(int i=0; i<4; i++) {
                int dRow = dr[i] + arr[0];
                int dCol = dc[i] + arr[1];
                if(dRow < 0 || dCol < 0 || dRow >= m || dCol >= n) continue;
                if(visited[dRow][dCol] || picture[dRow][dCol] != stand) continue;
                count++;
                visited[dRow][dCol] = true;
                q.offer(new int[]{dRow, dCol});
            }
            
        }
        return count;
    }
    
}
