import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1+o2;
                String str2 = o2+o1;
                return str2.compareTo(str1);
            }
        });

        for(int number : numbers) pq.add(String.valueOf(number));
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) sb.append(pq.poll());
        String str = sb.toString();
        return str.charAt(0) == '0' ? "0" : str;
    }
}