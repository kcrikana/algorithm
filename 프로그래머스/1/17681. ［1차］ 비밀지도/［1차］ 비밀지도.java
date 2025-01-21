import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.setLength(0);
            int num = arr1[i]|arr2[i];
            for(int j=n-1; j>=0; j--) {
                if(((1 << j)&num) != 0) sb.append('#');
                else sb.append(' ');
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}