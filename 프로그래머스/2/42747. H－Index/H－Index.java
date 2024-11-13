import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int maxCount = citations.length;
        int[] arr = new int[10001];
        for(int num : citations) {
            arr[num]++;
        }
        int count = 0;
        int answer = 0;
        for(int i=0; i<=10000; i++) {
            if(i != 0) count += arr[i-1];
            if(maxCount-count >= i && count < i) answer = i;
        }
        return answer;
    }
}