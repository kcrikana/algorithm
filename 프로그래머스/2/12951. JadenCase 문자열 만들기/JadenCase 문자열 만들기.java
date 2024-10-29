import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isUpper = true;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(isUpper) {
                ch = Character.toUpperCase(ch);
                isUpper = false;
            }
            else ch = Character.toLowerCase(ch);
            if(ch == ' ') isUpper = true;
            sb.append(ch);
        }
        return sb.toString();
    }
}