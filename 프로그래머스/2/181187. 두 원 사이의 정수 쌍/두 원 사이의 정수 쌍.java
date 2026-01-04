import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int i=0; i<r2; i++) {
            long y2 = (long)Math.sqrt(Math.pow(r2,2)-Math.pow(i,2));
            long y1 = 0l;
            if(i < r1) {
                y1 = (long)Math.ceil(Math.sqrt(Math.pow(r1,2)-Math.pow(i,2)))-1;
            }
            answer += y2-y1;
        }
        
        return answer*4l;
    }
}