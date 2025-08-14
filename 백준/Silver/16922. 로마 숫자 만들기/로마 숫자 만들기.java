import java.io.*;
import java.util.*;

public class Main {
    static HashSet<Integer> set = new HashSet<>();
    static int N;
    static int[] arr = {1, 5, 10, 50};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        backTracking(0,0, 0);
        System.out.println(set.size());
    }

    static void backTracking(int depth, int sum, int num) {
        if(depth == N) {
            set.add(sum);
            return;
        }
        for(int i=num; i<4; i++) {
            backTracking(depth+1, sum+arr[i], i);
        }
    }
}