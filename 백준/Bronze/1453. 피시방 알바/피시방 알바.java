import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int count = 0;
        boolean[] visit = new boolean[101];
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(visit[num]) count++;
            else visit[num] = true;
        }
        System.out.println(count);
    }
}