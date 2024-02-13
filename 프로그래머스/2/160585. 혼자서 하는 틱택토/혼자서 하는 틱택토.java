import java.util.*;
class Solution {
    char[][] tik = new char[3][3];
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                char ch = board[i].charAt(j);
                tik[i][j] = ch;
                if(ch == 'O') oCount++;
                else if(ch == 'X') xCount++;
            }
        }
        int answer = 1;
        boolean oCheck = check('O');
        boolean xCheck = check('X');
        if(xCount > oCount) answer = 0;
        else if(Math.abs(xCount-oCount) >= 2) answer = 0;
        if (oCheck && xCount + 1 != oCount) answer = 0;
        else if(xCheck && xCount != oCount) answer = 0;
        return answer;
    }
    
    boolean check(char ch) {
        for(int i=0; i<3; i++) {
            boolean isTruth = true;
            for(int j=0; j<3; j++) {
                if(tik[i][j] != ch) {
                    isTruth = false;
                    break;
                }
            }
            if(isTruth) return true;
        }
        for(int i=0; i<3; i++) {
            boolean isTruth = true;
            for(int j=0; j<3; j++) {
                if(tik[j][i] != ch) {
                    isTruth = false;
                    break;
                }
            }
            if(isTruth) return true;
        }
        if (tik[0][0] == ch && tik[1][1] == ch && tik[2][2] == ch) return true;
        if (tik[2][0] == ch && tik[1][1] == ch && tik[0][2] == ch) return true;
        return false;
    }
}