import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int num = (int)(right - left)+1;
        int[] arr = new int[num];
        for(int i=0; i<num; i++) {
            int row = (int)((i+left)/n)+1;
            int col = (int)((i+left)%n)+1;
            arr[i] = Math.max(row,col);
        }
        return arr;
    }
}