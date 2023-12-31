import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int K = 1;
        int result = 0;
        while(N>0) {
            if(N<K) K=1;
            N -= K;
            result++;
            K++;
        }
        System.out.println(result);
    }
}