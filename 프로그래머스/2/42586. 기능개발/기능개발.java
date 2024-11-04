import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int day = (100-progresses[i])/speeds[i];
            day = (100-progresses[i])%speeds[i] != 0 ? day+1 : day;
            q.offer(day);
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int now = 0;
        while(!q.isEmpty()) {
            if(now == 0) now = q.poll();
            else q.poll();
            count++;
            if(q.isEmpty() || q.peek() > now) {
                list.add(count);
                count = 0;
                now = 0;
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }

}