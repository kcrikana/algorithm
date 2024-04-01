import java.util.*;
class Solution {
    boolean[][] pillar;
    boolean[][] bo;
    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n+1][n+1];
        bo = new boolean[n+1][n+1];
        int count = 0;
        for(int[] arr : build_frame) {
            int x = arr[0];
            int y = arr[1];
            int type = arr[2];
            int action = arr[3];
            if(type == 0) {
                if(action == 1) {
                    if(isPillar(x,y)) {
                        pillar[x][y] = true;
                        count++;
                    }
                }
                else {
                    pillar[x][y] = false;
                    if(!delete(n)) pillar[x][y] = true;
                    else count--;
                }
            }
            else {
                if(action == 1) {
                    if(isBo(x,y)) {
                        bo[x][y] = true;
                        count++;
                    }
                }
                else {
                    bo[x][y] = false;
                    if(!delete(n)) bo[x][y] = true;
                    else count--;
                }
            }
        }
        int[][] answer = new int[count][3];
        int idx = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(pillar[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j; 
                    answer[idx++][2] = 0;
                }
                if(bo[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 1;
                }
            }
        }
        return answer;
    }
    
    boolean isPillar(int x, int y) {
        if(y == 0) return true;
        else if(y > 0 && pillar[x][y - 1]) return true; 
        else if(x > 0 && bo[x - 1][y] || bo[x][y]) return true;
        return false;
    }
    
    boolean isBo(int x, int y) {
        if(y > 0 && pillar[x][y - 1] || pillar[x + 1][y - 1]) return true; 
        else if(x > 0 && bo[x - 1][y] && bo[x + 1][y]) return true; 
        return false;
    }
    
    boolean delete(int n) {    
        for(int i = 0; i <= n; i++) { 
            for(int j = 0; j <= n; j++) { 
                if(pillar[i][j] && isPillar(i, j) == false)  return false; 
                else if(bo[i][j] && isBo(i, j) == false) return false;
            }
        }
        return true;
    }
}