import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];
        for(int i=0; i<players.length; i++) {
            int minServer = players[i]/m;
            if(minServer > server[i]) {
                int increase = minServer-server[i];
                answer += increase;
                for(int j=i; j<k+i && j < 24; j++) {
                    server[j] += increase;
                }
            }
        }
        return answer;
    }
}