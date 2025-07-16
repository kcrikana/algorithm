import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[6][9];
        for (int i = 0; i < 6; i++) {
            board[i] = bf.readLine().toCharArray();
        }
        int answer = Integer.MAX_VALUE;
        
        for (char c1 = 'A'; c1 <= 'Z';c1++){
            for (char c2 = 'A'; c2 <= 'Z'; c2++) {
                if (c1 == c2) continue;
                for (char c3 = 'A'; c3 <= 'Z'; c3++) {
                    if (c3 == c2) continue;
                    int rowCnt = 0;
                    int colCnt = 0;
                    for (int x = 0; x < 9; x++) {
                        for (int y = 0; y < 2; y++) {
                            if (board[y][x] != c1) rowCnt++;
                        }
                        for (int y = 2; y < 4; y++) {
                            if (board[y][x] != c2) rowCnt++;
                        }
                        for (int y = 4; y < 6; y++) {
                            if (board[y][x] != c3) rowCnt++;
                        }
                    }
                    for (int y = 0; y < 6; y++) {
                        for (int x = 0; x < 3; x++) {
                            if (board[y][x] != c1) colCnt++;
                        }
                        for (int x = 3; x < 6; x++) {
                            if (board[y][x] != c2) colCnt++;
                        }
                        for (int x = 6; x < 9; x++) {
                            if (board[y][x] != c3) colCnt++;
                        }
                    }
                    answer = Math.min(answer, rowCnt);
                    answer = Math.min(answer, colCnt);
                }
            }
        }
        System.out.println(answer);
    }
}