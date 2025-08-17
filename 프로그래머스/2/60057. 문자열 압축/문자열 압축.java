import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length() == 1) return 1;
        int len = s.length()/2;
        for(int i=1; i<=len; i++) {
            String now = compression(s, i, s.length());
            answer = Math.min(answer, now.length());
        }
        return answer;
    }
    
    String compression(String s, int unit, int max) {
        String cutStr = s.substring(0, unit);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        String now = "";
        for(int i=0; i<max; i+=unit) {
            if(i+unit > max) now = s.substring(i, max);
            else now = s.substring(i,i+unit);
            if(cutStr.equals(now)) count++;
            else {
                if(count>1) sb.append(count);
                sb.append(cutStr);
                cutStr = now;
                count = 1;
            }
        }
        if(count>1) sb.append(count);
        sb.append(cutStr);
        return sb.toString();
    }
}