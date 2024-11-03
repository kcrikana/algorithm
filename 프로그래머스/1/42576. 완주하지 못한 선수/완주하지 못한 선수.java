import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String str : participant) {
            map.put(str, map.getOrDefault(str,0)+1);
        }
        for(String str : completion) {
            int num = map.get(str)-1;
            if(num == 0) map.remove(str);
            else map.put(str, num);
        }
        for(String str : map.keySet()) answer = str;
        return answer;
    }
}