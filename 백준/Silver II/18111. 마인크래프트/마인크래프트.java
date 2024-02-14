import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] minecraft = new int[N][M];
        int maxH = 0;
        int minH = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++) {
                minecraft[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, minecraft[i][j]);
                minH = Math.min(minH, minecraft[i][j]);
            }
        }
        int result = 0;
        int minTime = Integer.MAX_VALUE;
        for(int i=maxH; i>=minH; i--) {
            int block = 0;
            int time = 0;
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    int num = Math.abs(i-minecraft[j][k]);
                    if(minecraft[j][k] < i) {
                        block -= num;
                        time += num;
                    }
                    else if(minecraft[j][k] > i) {
                        block += num;
                        time += num*2;
                    }
                }
            }
            if(block+B >= 0 && time<minTime) {
                minTime = time;
                result = i;
            }
        }
        System.out.println(minTime + " " + result);
    }
}