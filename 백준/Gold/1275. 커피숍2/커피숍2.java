import java.io.*;
import java.util.*;

public class Main {

    static class Seg {
        private long[] tree;
        public Seg(int num) {
            double h = Math.ceil(Math.log(num)/Math.log(2))+1;
            long treeNodeCount = Math.round(Math.pow(2,h));
            tree = new long[Math.toIntExact(treeNodeCount)];
        }

        public long init(long[] arr, int node, int start, int end) {

            if(start == end) return tree[node] = arr[start];
            return tree[node] = init(arr,node*2,start,(start+end)/2)+
                init(arr, node*2+1, (start+end)/2+1, end);
        }

        public long update(int node, int start, int end, int idx, int change) {
            if(idx < start || end < idx) return tree[node];
            else if(start == idx && end == idx) return tree[node] = change;
            else {
                return tree[node] = update(node*2, start, (start+end)/2, idx, change) +
                    update(node*2+1, (start+end)/2+1, end, idx, change);
            }
        }

        public long sum(int node, int start, int end, int left, int right) {
            if(left > end || right < start) return 0;
            if(left <= start && end <= right) return tree[node];
            return sum(node*2, start, (start+end)/2, left, right)+
                sum(node*2+1, (start+end)/2+1, end, left, right);
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N+1];
        st = new StringTokenizer(bf.readLine());
        for(int i=1; i<=N; i++) arr[i] = Long.parseLong(st.nextToken());
        Seg seg = new Seg(N);
        seg.init(arr, 1, 1, N);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(x>y) sb.append(seg.sum(1,1,N,y,x)).append('\n');
            else sb.append(seg.sum(1,1,N,x,y)).append('\n');
            seg.update(1,1,N,a,b);
        }
        System.out.println(sb);
    }
}
