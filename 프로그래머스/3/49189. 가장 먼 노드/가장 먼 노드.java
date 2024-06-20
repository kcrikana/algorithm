import java.util.*;
class Solution {
    int[] distance;
    public int solution(int n, int[][] edge) {
        distance = new int[n+1];
        distance[1] = 1;
        ArrayList<Integer>[] list;
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) list[i] = new ArrayList<>();
        for(int[] node : edge) {
            list[node[0]].add(node[1]);
            list[node[1]].add(node[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int num : list[now]) {
                if(distance[num] == 0) {
                    q.offer(num);
                    distance[num] = distance[now]+1;
                }
            }
        }
        Arrays.sort(distance);
        int answer = 1;
        for(int i=n-1; i>0; i--) {
            if(distance[i] != distance[n]) break;
            answer++;
        }
        return answer;
    }
}