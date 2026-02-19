import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int len;
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        len = begin.length();
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    void dfs(String begin, String target, String[] words, int depth) {
        if(target.equals(begin)) {
            answer = Math.min(depth, answer);
            return;
        }
        for(int i=0; i<words.length; i++) {
            if(visited[i]) continue;
            if(change(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, depth+1);
                visited[i] = false;
            }
        }
    }
    
    boolean change(String begin, String word) {
        int count = 0;
        for(int i=0; i<len; i++) {
            if(begin.charAt(i) != word.charAt(i)) count++;
        }
        if(count == 1) return true;
        return false;
    }
}