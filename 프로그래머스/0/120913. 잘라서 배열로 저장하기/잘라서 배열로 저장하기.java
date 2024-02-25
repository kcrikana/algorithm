import java.util.*;
class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length()%n == 0 ? my_str.length()/n : my_str.length()/n+1;
        String[] answer = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<my_str.length(); i++) {
            sb.append(my_str.charAt(i));
            if(sb.length() == n || i == my_str.length()-1) {
                answer[i/n] = sb.toString();
                sb = new StringBuilder();
            }
        }
        return answer;
    }
}