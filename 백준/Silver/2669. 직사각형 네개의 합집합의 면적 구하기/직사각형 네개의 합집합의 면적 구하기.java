import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] visit = new boolean[101][101];
        StringTokenizer st;
        for(int i=0; i<4; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int j=x1; j<x2; j++) {
                for(int k=y1; k<y2; k++) {
                    visit[j][k] = true;
                }
            }
        }
        int count = 0;
        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                if(visit[i][j]) count++;
            }
        }
        System.out.println(count);
    }
}