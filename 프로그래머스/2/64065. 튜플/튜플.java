import java.util.*;
class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = s.length();
        String str = s.substring(2,len-2).replace("},{", "-");
        String[] arr = str.split("-");
        Arrays.sort(arr, (o1,o2) -> Integer.compare(o1.length(),o2.length()));
        for(String now : arr) {
            StringTokenizer st = new StringTokenizer(now, ",");
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if(!list.contains(num)) list.add(num);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}