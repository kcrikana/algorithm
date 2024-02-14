import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[2];
        StringTokenizer st;
        for(int i=0; i<2; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] += Integer.parseInt(st.nextToken())*6;
            arr[i] += Integer.parseInt(st.nextToken())*3;
            arr[i] += Integer.parseInt(st.nextToken())*2;
            arr[i] += Integer.parseInt(st.nextToken());
            arr[i] += Integer.parseInt(st.nextToken())*2;
        }
        System.out.println(arr[0] + " " + arr[1]);
    }
}