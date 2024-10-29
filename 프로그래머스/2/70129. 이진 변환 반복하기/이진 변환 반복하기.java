import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int binaryCount = 0;
        while(true) {
            if(s.length() == 1) break;
            binaryCount++;
            int len = 0;
            for(int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == '1') len++;
                else zeroCount++;
            }
            s = Integer.toBinaryString(len);
        }
        answer[0] = binaryCount;
        answer[1] = zeroCount;
        return answer;
    }
}