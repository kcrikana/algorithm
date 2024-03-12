import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int min = Integer.MAX_VALUE;
        while(N-->0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A<=B) min = Math.min(min, B);
        }
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}