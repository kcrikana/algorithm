import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0l;
        long sum2 = 0l;
        int maxSize = queue1.length+queue2.length+1;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++) {
            sum1 += (long)queue1[i];
            q1.offer((long)queue1[i]);
        }
        for(int i=0; i<queue2.length; i++) {
            sum2 += (long)queue2[i];
            q2.offer((long)queue2[i]);
        }
        if((sum1+sum2)%2l != 0) return -1;
        if(sum1 == sum2) return 0;
        int count = 0;
        while(!q1.isEmpty() && !q2.isEmpty() && maxSize >= count) {
            count++;
            long num = 0l;
            if(sum1 > sum2) {
                num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
            }
            else {
                num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.offer(num);
            }
            if(sum1 == sum2) return count;
        }
        return -1;
    }
}