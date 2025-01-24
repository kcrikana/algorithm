import java.util.*;
class Solution {
    HashMap<String, Integer> inMap = new HashMap<>();
    TreeMap<String, Integer> outMap = new TreeMap<>();
    public int[] solution(int[] fees, String[] records) {
        for(String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            String[] str = st.nextToken().split(":");
            int time = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
            String car = st.nextToken();
            if(st.nextToken().equals("IN")) inMap.put(car, time);
            else resultTime(time, car);
        }
        for(String car : inMap.keySet()) outMap.put(car, outMap.getOrDefault(car, 0)+1439-inMap.get(car));
        int[] answer = new int[outMap.size()];
        int idx = 0;
        for(String car : outMap.keySet()) {
            int time = outMap.get(car);
            int result = fees[1];
            if(time > fees[0]) {
                time -= fees[0];
                result += fees[3]*(time/fees[2]);
                result += time%fees[2] != 0 ? fees[3] : 0;
            }
            answer[idx++] = result;
        }
        return answer;
    }
    void resultTime(int time, String car) {
        outMap.put(car, outMap.getOrDefault(car, 0)+time-inMap.get(car));
        inMap.remove(car);
    }
}