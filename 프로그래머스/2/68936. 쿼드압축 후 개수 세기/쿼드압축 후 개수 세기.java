import java.util.*;
class Solution {
    int[][] qtree;
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        qtree = arr;
        tree(arr.length, 0, 0);
        return answer;
    }
    void tree(int num, int row, int col) {
        if(res(num, row, col)) {
            answer[qtree[row][col]]++;
            return;
        }
        int size = num/2;
        tree(size, row, col);
        tree(size, row+size, col);
        tree(size, row, col+size);
        tree(size, row+size, col+size);
    }
    
    boolean res(int num, int row, int col) {
        int result = qtree[row][col];
        for(int i=row; i<row+num; i++) {
            for(int j=col; j<col+num; j++) if(result != qtree[i][j]) return false;
        }
        return true;
    }
}