import java.util.*;
import java.io.*;
public class Main {
    static int N, M, K;
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean isTruth = false;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        StringBuilder sb = new StringBuilder();
        ArrayList<int[]> list = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    list.add(new int[]{i, j});
                    sum++;
                }
            }
        }
        if(sum == K) {
            sb.append(K).append('\n');
            for(int[] now : list) sb.append(now[0]+1).append(' ').append(now[1]+1).append('\n');
        }
        else if(sum == 2*K) sb.append(0).append('\n');
        else {
            int num = 2*K-sum;
            sb.append(num).append('\n');
            for(int[] now : list) {
                boolean cross = bfs(now[0], now[1]);
                if(cross) {
                    sb.append(now[0]+1).append(' ').append(now[1]+1).append('\n');
                    break;
                }
            }
            if(!isTruth) {
                for(int i=K-num; i<K; i++) sb.append(list.get(i)[0]+1).append(' ').append(list.get(i)[1]+1).append('\n');
            }
        }
        System.out.println(sb);
    }
    static boolean bfs(int startRow, int startCol) {
        boolean[] cross = new boolean[4];
        for(int i=0; i<4; i++) {
            int dRow = startRow+dr[i];
            int dCol = startCol+dc[i];
            if(dRow < 0 || dRow >= N || dCol < 0 || dCol >= M) continue;
            if(arr[dRow][dCol] == 1) {
                cross[i] = true;
            }
        }
        if((cross[0]||cross[2])&&(cross[1]||cross[3])) {
            isTruth = true;
            return true;
        }
        return false;
    }
}