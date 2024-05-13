import java.util.*;
class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visit[i]){
                dfs(computers,i,n);
                answer++;
            }
        }
        return answer;
    }
    static void dfs(int[][] computers, int now,int n) {
        visit[now] = true;
        for(int i=0; i<n; i++) {
            if(i != now && computers[now][i] == 1 && !visit[i]) dfs(computers,i,n);
        }
    }
}