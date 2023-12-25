import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        for(int i=1; i<=N; i++) {
            String str = bf.readLine();
            map1.put(str,String.valueOf(i));
            map2.put(String.valueOf(i),str);
        }
        for(int i=0; i<M; i++) {
            String str = bf.readLine();
            sb.append(map1.getOrDefault(str, map2.get(str))).append('\n');
        }
        System.out.println(sb);
    }
}