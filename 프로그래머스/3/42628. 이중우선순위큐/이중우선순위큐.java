import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st;
        int[] answer = new int[2];
        for(String operation : operations) {
            st = new StringTokenizer(operation);
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(str.equals("I")) set.add(num);
            else {
                if(num == 1) {
                    if(!set.isEmpty()) set.pollLast();
                }
                else {
                    if(!set.isEmpty()) set.pollFirst();
                }
            }
        }
        if(!set.isEmpty()) {
            answer[0] = set.last();
            answer[1] = set.first();
        }
        return answer;
    }
}