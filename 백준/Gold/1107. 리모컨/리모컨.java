import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        boolean[] visit = new boolean[10];
        if(M > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0; i<M; i++) visit[Integer.parseInt(st.nextToken())] = true;
        }
        int ans = Math.abs(N-100);
        for(int i=0; i<=999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            boolean isBreak = false;
            for(int j=0; j<len; j++) {
                if(visit[str.charAt(j)-'0']){
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak) {
                int min = Math.abs(N-i) + len;
                ans = Math.min(min, ans);
            }
        }
        System.out.println(ans);
    }
}