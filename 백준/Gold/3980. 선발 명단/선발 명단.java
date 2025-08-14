import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[] visited;

    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0) {
            arr = new int[11][11];
            visited = new boolean[11];
            max = 0;
            for(int i=0; i<11; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            backTracking(0, 0);
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }

    static void backTracking(int depth, int sum) {
        if(depth == 11) {
            max = Math.max(max, sum);
            return;
        }
        for(int i=0; i<11; i++) {
            if(!visited[i] && arr[depth][i] > 0) {
                visited[i] = true;
                backTracking(depth+1, sum + arr[depth][i]);
                visited[i] = false;
            }
        }
    }
}