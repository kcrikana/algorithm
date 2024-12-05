import java.util.*;
class Solution {
    public String solution(String[] seoul) {
        HashSet<String> set = new HashSet<>();
        set.add("Kim");
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ");
        for(int i=0; i<seoul.length; i++) {
            if(set.contains(seoul[i])) {
                sb.append(i).append("에 있다");
                break;
            }
        }
        return sb.toString();
    }
}