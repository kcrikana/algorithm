import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-->0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            for(int i=0; i<num2; i++) {
                for(int j=0; j<num1; j++) sb.append('X');
                sb.append('\n');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}