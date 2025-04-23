import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int start = 1;
        int end = N-1;
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        boolean[] visited;
        int result = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            visited = new boolean[N];
            int today = N-1;
            boolean isTruth = false;
            int count = 0;
            while(count < K) {
                if(visited[today]) break;
                visited[today] = true;
                if(arr[today] == 1) {
                    today -= mid;
                    count++;
                    if(today <= 0) {
                        isTruth = true;
                        break;
                    }
                }
                else today++;
                if(today == N) break;
            }
            if(isTruth) {
                result = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        System.out.println(result);
    }
}