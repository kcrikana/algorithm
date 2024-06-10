import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = times[0];
        long end = (long)times[times.length-1]*(long)n;
        long answer = 0l;
        while(start <= end) {
            long sum = 0l;
            long mid = (end+start)/2;
            for(int time : times) sum += mid/time;
            if(sum >= n) {
                answer = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return answer;
    }
}