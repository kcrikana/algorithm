import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int row = n%w == 0 ? n/w : n/w+1;
        int[][] arr = new int[row][w];
        int targetRow = n/w;
        int targetCol = n%w;
        int now = 1;
        for(int i=0; i<row; i++) {
            if(i%2 == 0) {
                for(int j=0; j<w; j++) {
                    arr[i][j] = now;
                    if(now == num) {
                        targetRow = i;
                        targetCol = j;
                    }
                    now++;
                }
            }
            else {
                for(int j=w-1; j>=0; j--) {
                    arr[i][j] = now;
                    if(now == num) {
                        targetRow = i;
                        targetCol = j;
                    }
                    now++;
                }
            }
        }
        
        while(targetRow < row) {
            if(arr[targetRow][targetCol] != 0 && arr[targetRow][targetCol] <= n) answer++;
            else break;
            targetRow++;
        }
        return answer;
    }
}