import java.util.*;
import java.io.*;

public class Main {
    static long N,P,Q,X,Y;
    static Map<Long,Long> map;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        map.put(0l,1l);
        dfs(N);
        System.out.println(map.get(N));
    }
    static long dfs(long n) {
        if(map.containsKey(n)) return map.get(n);
        long res1 = ((long)Math.floor(n/P)-X) <= 0 ? 1 : dfs((long)Math.floor(n/P)-X);
        long res2 = ((long)Math.floor(n/Q)-Y) <= 0 ? 1 : dfs((long)Math.floor(n/Q)-Y);
        map.put(n,res1+res2);
        return res1 + res2;
    }
}