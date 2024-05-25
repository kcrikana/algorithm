import java.util.*;
class Solution {
    boolean[] visit;
    List<Integer> list;
    public int solution(int[] cards) {
        visit = new boolean[cards.length];
        list = new ArrayList<>();
        for(int i=0; i<cards.length; i++) {
            if(!visit[i]) {
                list.add(dfs(cards, 0, i));
            }
        }
        int answer = 0;
        Collections.sort(list,Collections.reverseOrder());
        if(list.size() != 1) answer = list.get(0)*list.get(1);
        return answer;
    }
    int dfs(int[] cards, int depth, int idx) {
        if(visit[idx]) return depth;
        else {
            visit[idx] = true;
            return dfs(cards, depth+1, cards[idx]-1);
        }
    }
}