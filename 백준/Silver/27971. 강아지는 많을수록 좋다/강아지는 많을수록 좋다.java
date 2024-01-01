import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        int idx, cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static int N, M, A, B;
    static boolean[] visit;
    static int[] graph;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        graph = new int[] {A,B};
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            for(int j=num1; j<=num2; j++) visit[j] = true;
        }
        bfs();
        System.out.println(ans == 0 ? -1 : ans);
    }
    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0));
        visit[0] = true;
        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int i=0; i<2; i++) {
                int dIdx = now.idx+graph[i];
                if(dIdx>N) continue;
                else if(dIdx == N) {
                    ans = now.cost +1;
                    return;
                }
                else if(visit[dIdx]) continue;
                q.offer(new Node(dIdx,now.cost+1));
                visit[dIdx] = true;
            }
        }
    }
}