import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int min = Integer.MAX_VALUE;
        int ans = 0;
        while(N-->0) {
            int now = Integer.parseInt(st.nextToken());
            ans = Math.max(ans,now-min);
            min = Math.min(min,now);
        }
        System.out.println(ans);
    }
}