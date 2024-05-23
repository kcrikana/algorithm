import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        StringTokenizer st;
        int num = 0;
        for(String log : record) {
            st = new StringTokenizer(log);
            String str = st.nextToken();
            if(str.equals("Leave")) {
                num++;
                continue;
            }
            else if(str.equals("Enter")) num++;
            map.put(st.nextToken(), st.nextToken());
        }
        String[] answer = new String[num];
        int now = 0;
        for(String log : record) {
            st = new StringTokenizer(log);
            String str1 = st.nextToken();
            if(str1.equals("Enter")) {
                String str2 = map.get(st.nextToken());
                answer[now++] = str2 + "님이 들어왔습니다.";
            }
            else if(str1.equals("Leave")) {
                String str2 = map.get(st.nextToken());
                answer[now++] = str2 + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}