import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] arr = new int[3][];
        arr[0] = new int[]{1,2,3,4,5};
        arr[1] = new int[]{2,1,2,3,2,4,2,5};
        arr[2] = new int[]{3,3,1,1,2,2,4,4,5,5}; 
        int[] len = new int[3];
        len[0] = arr[0].length;
        len[1] = arr[1].length;
        len[2] = arr[2].length;
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        for(int i=0; i<3; i++) {
            int count = 0;
            for(int j=0; j<answers.length; j++) {
                if(answers[j] == arr[i][j%len[i]]) count++;
            }
            max = Math.max(count, max);
            list.add(count);
        }
        int count = 0;
        for(int i=0; i<3; i++) {
            if(list.get(i) == max) {
                count++;
            }
        }
        int[] answer = new int[count];
        int idx = 0;
        for(int i=0; i<3; i++) {
            if(list.get(i) == max) {
                answer[idx++] = i+1;
            }
        }
        return answer;
    }
}