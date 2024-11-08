import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int idx = 0;
        int[] answer = new int[commands.length];
        for(int[] arr : commands) {
            List<Integer> list = new ArrayList<>();
            for(int j=arr[0]-1; j<arr[1]; j++) list.add(array[j]);
            Collections.sort(list);
            answer[idx++] = list.get(arr[2]-1);
        }
        return answer;
    }
}