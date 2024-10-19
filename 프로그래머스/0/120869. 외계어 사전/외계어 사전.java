import java.util.*;
class Solution {
    static boolean[] visit;
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<spell.length; i++) {
            map.put(spell[i], 1);
        }
        for(String str : dic) {
            if(str.length() != spell.length) continue;
            isVisit(spell);
            boolean isTruth = true;
            for(int j=0; j<str.length(); j++) {
                int num = str.charAt(j)-'a';
                if(visit[num]) visit[num]=false;
                else {
                    isTruth = false;
                    break;
                }
            }
            if(isTruth) {
                answer = 1;
                break;
            }
        }        
        return answer;
    }
    
    void isVisit(String[] spell) {
        int num = spell.length;
        visit = new boolean[27];
        for(int i=0; i<num; i++) {
            int now = spell[i].charAt(0)-'a';
            visit[now] = true;
        }
    }
}