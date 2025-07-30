import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][];
        visited = new boolean[N][10];
        result = new int[N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            arr[i] = new int[size];
            for(int j=0; j<size; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(-1);
    }

    static void dfs(int depth, int past) {
        if(depth == N) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++) sb.append(result[i]).append('\n');
            System.out.println(sb);
            System.exit(0);
        }
        for(int next : arr[depth]) {
            if(!visited[depth][next]) {
                if(next != past) {
                    visited[depth][next] = true;
                    result[depth] = next;
                    dfs(depth+1, next);
                }
            }
        }
    }
}