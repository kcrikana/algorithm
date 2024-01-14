import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long A = Math.min(N,M);
        long B = Math.max(N,M);
        long sum = (((B + 1) * B) / 2) - (((A - 1) * A) / 2);
        System.out.println(sum);
    }
}