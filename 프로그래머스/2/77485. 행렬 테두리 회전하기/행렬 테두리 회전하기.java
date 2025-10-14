import java.util.*;

class Solution {
    int[][] arr;
    int[] answer;
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        arr = new int[rows][columns];
        int count = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                arr[i][j] = count;
                count++;     
            }
        }
        for(int i=0; i<queries.length; i++) rotate(i, queries[i]);
        return answer;
    }
    
    void rotate(int idx, int[] queries) {
        int x1 = queries[0]-1;
        int y1 = queries[1]-1;
        int x2 = queries[2]-1;
        int y2 = queries[3]-1;
        
        int[] right = new int[y2-y1];
        int[] left = new int[y2-y1];
        int[] bottom = new int[x2-x1];
        int[] top = new int[x2-x1];
        
        int min = 1000000;
        for(int i=0; i<(y2-y1); i++) {
            right[i] = arr[x1][y1+i];
            left[i] = arr[x2][y2-i];
            min = Math.min(right[i], min);
            min = Math.min(left[i], min);
        }
        
        for(int i=0; i<(x2-x1); i++) {
            bottom[i] = arr[x1+i][y2];
            top[i] = arr[x2-i][y1];
            min = Math.min(top[i], min);
            min = Math.min(bottom[i], min);
        }
        
        for(int i=0; i<(y2-y1); i++) {
            arr[x1][y1+i+1] = right[i];
            arr[x2][y2-i-1] = left[i];
        }
        
        for(int i=0; i<(x2-x1); i++) {
            arr[x1+i+1][y2] = bottom[i];
            arr[x2-i-1][y1] = top[i];
        }
        answer[idx] = min;
    }
}