import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int count = 0;
        boolean[] visit = new boolean[C+1];
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(bf.readLine());
            for(int j=num; j<=C; j+=num) visit[j] = true;
        }
        for(boolean i : visit) count = i ? count+1 : count;
        System.out.println(count);
    }
}