import java.util.*;
class Solution {
    
    char[][] boards;
    boolean[][] visited;
    int[] dr = {0, 1, 1};
    int[] dc = {1, 1, 0};
    int mLen, nLen;
    int count = 0;
    
    public int solution(int m, int n, String[] board) {
        boards = new char[m][n];
        for(int i=0; i<m; i++) {
            boards[i] = board[i].toCharArray();
        }
        mLen = m;
        nLen = n;
        visited = new boolean[m][n];
        while(search()) block();
        return count;
    }
    
    boolean search() {
        boolean isTruth = false;
        for(int i=0; i<mLen-1; i++) {
            for(int j=0; j<nLen-1; j++) {
                if(boards[i][j] != '.' && check(i, j)) isTruth = true;
            }
        }
        return isTruth;
    }
    
    void block() {
        for(int i=0; i<mLen; i++) {
            for(int j=0; j<nLen; j++) {
                if(visited[i][j]) {
                    count++;
                    boards[i][j] = '.';
                }
            }
        }
        for(int i=mLen-1; i>=1; i--) {
            for(int j=0; j<nLen; j++) {
                if(boards[i][j] == '.') {
                    for(int k=i-1; k>=0; k--) {
                        if(boards[k][j] != '.') {
                            boards[i][j] = boards[k][j];
                            boards[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
        visited = new boolean[mLen][nLen];
    }
    
    boolean check(int row, int col) {
        for(int i=0; i<3; i++) {
            int dRow = row + dr[i];
            int dCol = col + dc[i];
            if(boards[row][col] != boards[dRow][dCol]) return false;
        }
        visited[row][col] = true;
        for(int i=0; i<3; i++) {
            int dRow = row + dr[i];
            int dCol = col + dc[i];
            visited[dRow][dCol] = true;
        }
        return true;
    }
}