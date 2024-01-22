import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int result = M;
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            M += num1-num2;
            result = Math.max(result, M);
            if(M<0) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }
}