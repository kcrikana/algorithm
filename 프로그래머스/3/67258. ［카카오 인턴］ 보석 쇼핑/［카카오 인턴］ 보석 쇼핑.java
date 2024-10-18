import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int min = 100001;
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<gems.length; i++) set.add(gems[i]);
        HashMap<String, Integer> map = new HashMap<>();
        int count = set.size();
        int start = 0;
        for(int i=0; i<gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0)+1);
            int num;
            while((num = map.get(gems[start]))>1)  map.put(gems[start++], num-1);
            if(map.size() == count && min > (i-start)) {
                min = i-start;
                answer[0] = start+1;
                answer[1] = i+1;
            }
        }
        return answer;
    }
}