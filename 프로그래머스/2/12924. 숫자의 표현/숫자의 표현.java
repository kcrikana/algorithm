import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 1;
        int start = 0;
        int end = 1;
        int sum = end+start;
        while(end < n && start<end) {
            if(sum == n) answer++;
            if(sum > n) {
                sum -= start;
                start++;
            }
            else {
                end++;
                sum += end;
            }
        }
        return answer;
    }
}