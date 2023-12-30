import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int F = Integer.parseInt(bf.readLine());
        int res = 0;
        N -= (N%100);
        for(int i=0; i<=99; i++) {
            if((N+i)%F == 0) {
                res = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(res/10 == 0) sb.append(0);
        sb.append(res);
        System.out.println(sb);
    }
}