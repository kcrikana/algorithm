import java.util.*;
class Solution {
    List<HashMap<String, Integer>> list = new ArrayList<>();
    boolean[] visited;
    public String[] solution(String[] orders, int[] course) {
        for(int i=0; i<=10; i++) list.add(new HashMap<>());
        for(String order : orders) {
            for(int target : course) {
                char[] ch = order.toCharArray();
                visited = new boolean[ch.length];
                Arrays.sort(ch);
                dfs(list.get(target), 0, target, "", ch, 0);
            }
        }
        List<String> answer = new ArrayList<>();
        for(int len : course) {
            int max = 0;
            HashMap<String, Integer> map = list.get(len);
            if(map.size() <= 0) continue;
            for(String str : map.keySet()) {
                if(map.get(str) >= 2) max = Math.max(max, map.get(str));
            }
            for(String str : map.keySet()) {
                if(map.get(str) == max) answer.add(str);
            }
        }
        
        Collections.sort(answer);
        return answer.stream().toArray(String[]::new);
    }
    
    void dfs(HashMap<String, Integer> map, int depth, int target, String str, char[] order, int idx) {
        if(depth == target) {
            int num = map.getOrDefault(str, 0)+1;
            map.put(str, num);
            return;
        }
        for(int i=idx; i<order.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(map, depth+1, target, str+order[i], order, i+1);
            visited[i] = false;
        }
    }
}