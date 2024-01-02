import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> r1 = new LinkedList<>();
        for(int i=0; i<N; i++) r1.add(Integer.parseInt(bf.readLine())-1,i);
        LinkedList<Integer> r2 = new LinkedList<>();
        for(int i=M-1; i>=0; i--) {
            int idx = r1.get(i);
            int cost = Integer.parseInt(bf.readLine())-1;
            r2.add(cost,idx);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++) sb.append(r2.get(i)+1).append('\n');
        System.out.println(sb);
    }
}