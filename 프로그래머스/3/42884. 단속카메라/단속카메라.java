import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int size = routes.length;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int now = -3000001;
        for(int[] arr : routes) {
            if(now < arr[0]) {
                now = arr[1];
                answer++;
            }
        }
        return answer;
    }
}