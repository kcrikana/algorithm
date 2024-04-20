import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) return cities.length*5;
        ArrayList<String> list = new ArrayList<>();
        for(String str : cities) {
            String city = str.toLowerCase();
            if(list.contains(city)) {
                list.remove(city);
                list.add(city);
                answer++;
            }
            else {
                if(list.size()>=cacheSize) list.remove(0);
                list.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}