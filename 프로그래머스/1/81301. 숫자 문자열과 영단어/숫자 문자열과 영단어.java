import java.util.*;
class Solution {
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int num = s.charAt(i)-'0';
            if(num >= 0 && num <= 9) {
                answer.append(num);
                sb = new StringBuilder();
            }
            else {
                sb.append(ch);
                if(map.containsKey(sb.toString())) {
                    int now = map.get(sb.toString());
                    answer.append(now);
                    sb = new StringBuilder();
                }
            }
        }
        int result = Integer.parseInt(answer.toString());
        return result;
    }
}