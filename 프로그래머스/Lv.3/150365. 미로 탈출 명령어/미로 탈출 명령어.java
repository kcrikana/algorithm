import java.util.*;
class Solution {
    String answer = null;
    int[] dr = {1,0,0,-1};
    int[] dc = {0,-1, 1,0};
    char[] dir = {'d','l','r','u'};
    StringBuilder sb = new StringBuilder();
    int endRow, endCol, rowSize, colSize;
    String solution(int n, int m, int x, int y, int r, int c, int k) {
        endRow = r;
        endCol = c;
        rowSize = n;
        colSize = m;
        int leng = dist(x,y,r,c);
        if((k-leng)%2 == 1 || k < leng) return "impossible";
        dfs(x,y,k,0);
        return answer == null ? "impossible" : answer;
    }
    
    void dfs(int r, int c, int k, int depth) {
        if(answer != null) return;
        if(depth + dist(r,c,endRow,endCol) > k) return;
        if(k == depth) {
            answer = sb.toString();
            return;
        }
        for(int i=0; i<4; i++) {
            int dRow = r + dr[i];
            int dCol = c + dc[i];
            if(dRow <= rowSize && dCol <= colSize && dRow>0 && dCol>0) {
                sb.append(dir[i]);
                dfs(dRow, dCol, k, depth+1);
                sb.delete(depth, depth+1);
            }
        }
    }
    
    int dist(int x, int y, int r, int c) {
        return (int)Math.abs(x-r)+(int)Math.abs(y-c);
    }
}