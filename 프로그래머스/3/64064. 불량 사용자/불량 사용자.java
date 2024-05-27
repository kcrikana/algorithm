import java.util.*;
class Solution {
    HashSet<String> set;
    boolean[] visit;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        set = new HashSet<>();
        visit = new boolean[user_id.length];
        for(int i=0; i<banned_id.length; i++) banned_id[i] = banned_id[i].replace("*", ".");
        dfs(0,"",user_id,banned_id);
        answer = set.size();
        return answer;
    }
    
    void dfs(int depth, String str, String[] user_id, String[] banned_id) {
        if(depth == banned_id.length) {
            String[] result = str.split("/");
            Arrays.sort(result);
            StringBuilder sb = new StringBuilder();
            for(String now : result) sb.append(now);
            set.add(sb.toString());
            return;
        }
        for(int i=0; i<user_id.length; i++) {
            if(visit[i] || !user_id[i].matches(banned_id[depth])) continue;
            visit[i] = true;
            dfs(depth+1,user_id[i]+"/"+str,user_id,banned_id);
            visit[i] = false;
        }
    }
}