import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = divide(p);
        return answer;
    }
    
    String divide(String str) {
        if(str.length() == 0) return "";
        int openCount = 0;
        int closeCount = 0;
        boolean isTruth = true;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') openCount++;
            else closeCount++;
            if(openCount < closeCount) isTruth = false;
            if(openCount != 0 && openCount == closeCount) {
                String u = str.substring(0, i+1);
                String v = str.substring(i+1, str.length());
                if(isTruth) return u + divide(v);
                else {
                    return "(" + divide(v) + ")" + change(u);
                }
            }
        }
        return str;
    }
    
    String change(String u) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<u.length()-1; i++) {
            if(u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }
}
