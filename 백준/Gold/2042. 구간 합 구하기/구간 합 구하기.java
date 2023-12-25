import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Seg {
        long[] tree;    // 각 원소에 담길 트리
        int treeSize;   // 트리의 크기

        public Seg(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize)/Math.log(2)); // 높이를 이용한 배열 사이즈 구하기
            this.treeSize = (int) Math.pow(2,h+1);      // 배열 생성
            tree = new long[treeSize];                  // arr = 원소배열, node = 현재노드, start = 현개구간 배열 시작,  end = 현재 구간 배열 끝
        }

        public long init(long[] arr , int node, int start, int end) {
            if(start == end) return tree[node] = arr[start];    // 배열의 시작과 끝이 갔다면 leaf 노드이므로 원소 배열 값 그대로 담기
            return tree[node] = init(arr,node*2,start,(start+end)/2)    // leaf 노드가 아니면 그대로 담기
                + init(arr,node*2+1,(start+end)/2+1,end);
        }

        public void update(int node, int start, int end, int idx, long diff) {
            if(idx < start || end < idx) return;
            tree[node] += diff;

            if(start != end) {
                update(node*2, start, (start+end)/2, idx, diff);
                update(node*2+1, (start+end)/2+1, end, idx, diff);
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
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Seg seg = new Seg(N);
        long[] arr = new long[N+1];
        for(int i=1; i<=N; i++) arr[i] = Long.parseLong(bf.readLine());
        seg.init(arr,1,1,N);
        for(int i=0; i<M+K; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==1) {
                long dif = c-arr[b];
                arr[b] = c;
                seg.update(1, 1, N,b,dif);
            }
            else if(a == 2) sb.append(seg.sum(1,1,N,b,(int)c)+"\n");
        }
        System.out.println(sb);
    }
}
