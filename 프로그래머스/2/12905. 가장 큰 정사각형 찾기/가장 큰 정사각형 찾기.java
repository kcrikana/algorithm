import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int row = board.length;
        int col = board[0].length;
        
        int[][] dp = new int[row][col];
        int max = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(board[i][j] == 1) {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                        max = Math.max(max, dp[i][j]);
                    }
                    else {
                        int min = Math.min(dp[i][j-1], dp[i-1][j]);
                        min = Math.min(min, dp[i-1][j-1]);
                        dp[i][j] = min+1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max*max;
    }
}