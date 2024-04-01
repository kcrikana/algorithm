import java.util.*;
class Solution {
    int answer = 0;
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] visit;
    String[] conditions;
    public int solution(int n, String[] data) {
        visit = new boolean[8];
        StringBuilder sb = new StringBuilder();
        conditions = data;
        dfs("", 0);
        return answer;
    }
    void dfs(String str, int depth) {
        if(8==depth) {
            if(isTruth(str)) answer++;
            return;
        }
        for(int i=0; i<8; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(str+friends[i],depth+1);
                visit[i] = false;
            }
        }
    }
    boolean isTruth(String str) {
        for(String arr : conditions)
        {
            int dist = (Math.abs(str.indexOf(arr.charAt(0)) - str.indexOf(arr.charAt(2))))-1;
            char sign = arr.charAt(3);
            int res = arr.charAt(4)-'0';
            if(sign == '=')
            {
                if(dist != res) return false;
            }
            else if(sign == '>')
            {
                if(dist <= res) return false;
            }
            else
            {
                if(dist >= res) return false;
            }
        }
        return true;
    }
}