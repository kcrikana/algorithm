import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        if(n <= cores.length) return n;
        int start = 1;
        int end = n*10000;
        int resultTime = 0;
        int work = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            int num = cores.length;
            for(int core : cores) num += mid/core;
            if(num >= n) {
                end = mid - 1;
                resultTime = mid;
                work = num;
            }
            else start = mid + 1;
        }
        work -= n; // 과계산 방지
        for(int i=cores.length-1; i>=0; i--) {
            if(resultTime%cores[i] == 0) {
                if(work == 0) return i+1;
                work--;
            }
        }
        return answer;
    }
}