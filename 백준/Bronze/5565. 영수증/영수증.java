import java.util.*;
import java.io.*;

public class Main {
    static long N,P,Q,X,Y;
    static Map<Long,Long> map;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(bf.readLine());
        for(int i=0; i<9; i++) sum -= Integer.parseInt(bf.readLine());
        System.out.println(sum);
    }
}