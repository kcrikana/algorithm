import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int N = order.length;
        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        int count = 0;
        while(count < N) {
            int targetNum = order[count++];
            if(idx <= targetNum) {
                while(idx != targetNum) stack.push(idx++);
                idx++;
                answer++;
            }
            else {
                if(stack.isEmpty() || stack.peek() != targetNum) break;
                else {
                    answer++;
                    stack.pop();
                }
            }
        }
        return answer;
    }
}