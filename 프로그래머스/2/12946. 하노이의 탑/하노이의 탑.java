import java.util.*;
class Solution {
    ArrayList<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
    
    void hanoi(int count, int left, int mid, int right) {
        if(count == 1) {
            list.add(new int[]{left, right});
            return;
        }
        hanoi(count-1, left, right, mid);
        list.add(new int[]{left, right});
        hanoi(count-1, mid, left, right);
    }
}