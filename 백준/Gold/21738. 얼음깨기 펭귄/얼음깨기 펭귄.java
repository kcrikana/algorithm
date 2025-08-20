import java.io.*;
import java.util.*;

public class Main {
    static int N, S, P;
    static ArrayList<Integer>[] list;
    static HashSet<Integer> set = new HashSet<>();
    static int end = 0;
    static boolean[] visited;
    static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=S; i++) set.add(i);
        for(int i=0; i<=N; i++) list[i] = new ArrayList<>();
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        func();
        System.out.println(N-result);
    }

    static void func() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(P);
        q.offer(0);
        visited[P] = true;
        while(!q.isEmpty() && end < 2) {
            int num = q.poll();
            int count = q.poll();
            for(int next : list[num]) {
                if(visited[next]) continue;
                visited[next] = true;
                if(set.contains(next)) {
                    end++;
                    result += count+1;
                }
                else {
                    q.offer(next);
                    q.offer(count+1);
                }
                if(end == 2) return;
            }
        }
    }
}