import java.io.*;
import java.util.*;


public class Main {

    static long MOD = 1000000007l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            if(N <= 2) sb.append(1l).append('\n');
            else sb.append(power(N-2)).append('\n');
        }
        System.out.println(sb);
    }

    static long power(int N) {
        if(N == 0) return 1l;
        long result = power(N/2);
        return result*result*(N%2+1)%MOD;
    }
}