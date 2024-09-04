import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        int idx = 0;
        int lastSize = 0;
        int count = 1;
        String lastWord = "";
        boolean isFirstWord = true;
        for(String str : words) {
            lastSize = set.size();
            set.add(str);
            if(isFirstWord) isFirstWord = false;
            else if(set.size() == lastSize || lastWord.charAt(lastWord.length()-1) != str.charAt(0)) {
                answer[0] = idx+1;
                answer[1] = count;
                break;
            }
            lastWord = str;
            if(idx == n-1) {
                idx = 0;
                count++;
            }
            else idx++;
        }
        return answer;
    }
}