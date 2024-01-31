import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
//        ArrayList<Integer> gra = new ArrayList<>(N*N);
//        ArrayList<Integer> arr = new ArrayList<>(N*N);
        int[] gra = new int[N*N];
        int[] arr = new int[N*N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//                gra.add(A[i] + B[j]);
//                arr.add(C[i] + D[j]);
                gra[idx] = A[i] + B[j];
                arr[idx] = C[i] + D[j];
                idx++;
            }
        }
//        Collections.sort(arr);
        Arrays.sort(arr);
        long count = 0;
        for(int res : gra) {
            int up = upperBound(arr, -res);
            int down = lowerBound(arr, -res);
            count += up-down;
        }
        System.out.println(count);
    }

    static int upperBound(int[] arr, int find) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int lowerBound(int[] arr, int find) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= find) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}