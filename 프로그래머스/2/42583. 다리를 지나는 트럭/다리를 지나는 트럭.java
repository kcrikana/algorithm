import java.util.*;
class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int idx = 0;
        int sum = 0;
        int maxIdx = truck_weights.length;
        Queue<Node> q = new LinkedList<>();
        while(idx < truck_weights.length || !q.isEmpty()) {
            time++;
            if(!q.isEmpty()) {
                Node now = q.peek();
                if(time - now.time >= bridge_length) {
                    sum -= now.weight;
                    q.poll();
                }
            }
            
            if(idx < maxIdx) {
                if(sum + truck_weights[idx] <= weight && q.size()+1 <= bridge_length) {
                    sum += truck_weights[idx];
                    q.offer(new Node(time, truck_weights[idx]));
                    idx++;
                }
            }
        }
        return time;
    }
    
    
    class Node {
        int time, weight;
        public Node(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
    }
}