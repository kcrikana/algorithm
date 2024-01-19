import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(bf.readLine());
        int N = 1;
        while(true) {
            if(S>=N) S -= N++;
            else break;
        }
        System.out.println(--N);
    }
}