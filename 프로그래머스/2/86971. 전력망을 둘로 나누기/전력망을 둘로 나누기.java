import java.util.*;
class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) list[i] = new ArrayList<>();
        for(int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        for(int[] wire : wires) {
            visited = new boolean[n+1];
            visited[wire[0]] = true;
            visited[wire[1]] = true;
            int count1 = bfs(wire[0]);
            int count2 = bfs(wire[1]);
            int num = Math.abs(count1-count2);
            answer = Math.min(num,answer);
        }
        return answer;
    }
    
    int bfs(int startIdx) {
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(startIdx);
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : list[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }   
        }
        return count;
    }
}