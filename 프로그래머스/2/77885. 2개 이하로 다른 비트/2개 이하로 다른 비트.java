import java.util.*;
class Solution {
    
    // 1111
    // 11101
    
    // 1001
    // 1010
    
    // 1000
    // 1001

    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        for(int i=0; i<len; i++) {
            if(numbers[i]%2l == 0l) answer[i] = numbers[i]+1;
            else answer[i] = numbers[i]+(Long.lowestOneBit(~numbers[i]) >> 1);
        }
        
        return answer;
    }
}