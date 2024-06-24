import java.util.*;
class Solution {
    ArrayList<Integer>[] list;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) list[i] = new ArrayList<>();
        for(int[] now : roads) {
            list[now[0]].add(now[1]);
            list[now[1]].add(now[0]);
        }
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++) {
            if(sources[i] == destination) answer[i] = 0;
            else answer[i] = bfs(n, sources[i], destination);
        }
        return answer;
    }
    
    int bfs(int n, int startPlace, int destination) {
        boolean[] visit = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(startPlace);
        q.add(0);
        visit[startPlace] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            int sum = q.poll();
            for(int num : list[now]) {
                if(visit[num]) continue;
                if(num == destination) return sum+1;
                visit[num] = true;
                q.add(num);
                q.add(sum+1);
            }
        }
        return -1;
    }
}