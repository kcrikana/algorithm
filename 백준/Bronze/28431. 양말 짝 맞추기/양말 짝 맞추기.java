import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        for(int i=0; i<5; i++) {
            int N = Integer.parseInt(bf.readLine());
            arr[N] = 1-arr[N];
        }
        for(int i=0; i<10; i++) {
            if(arr[i] == 1) System.out.println(i);
        }
    }
}