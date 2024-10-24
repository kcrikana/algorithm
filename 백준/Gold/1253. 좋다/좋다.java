import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for(int i=0; i<N; i++) {
        	int start = 0;
        	int end = N-1;
        	while(true) {
        		if(start == i) start++;
        		else if(end == i) end--;
        		if(start>=end) break;
        		else if(arr[start] + arr[end] == arr[i]) {
        			count++;
        			break;
        		}
        		else if(arr[start] + arr[end] < arr[i]) start++;
        		else end--;
        	}
        }
        System.out.println(count);
    }
}