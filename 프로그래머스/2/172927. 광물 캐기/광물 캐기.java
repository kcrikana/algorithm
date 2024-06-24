import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int count = Math.min(minerals.length/5+1, picks[0]+picks[1]+picks[2]);
        int[][] arr = new int[count][3];
        int idx = 0;
        for(int i=0; i<minerals.length; i+=5) {
            int dia = 0;
            int iron = 0;
            int stone = 0;
            if(i/5==count) break;
            for(int j=i; j<i+5; j++) {
                String str = minerals[j];
                if(str.equals("diamond")) {
                    dia++;
                    iron += 5;
                    stone += 25;
                }
                else if(str.equals("iron")) {
                    dia++;
                    iron++;
                    stone += 5;
                }
                else{
                    dia++;
                    iron++;
                    stone++;
                }
                if(j==minerals.length-1) break;
            }
            arr[i/5][0] = dia;
            arr[i/5][1] = iron;
            arr[i/5][2] = stone;
        }
        Arrays.sort(arr, (o1,o2) -> Integer.compare(o2[2],o1[2]));
        for(int i=0; i<count; i++) {
            if(picks[0] != 0) {
                answer += arr[i][0];
                picks[0]--;
            }
            else if(picks[1] != 0) {
                answer += arr[i][1];
                picks[1]--;
            }
            else if(picks[2] != 0){
                answer += arr[i][2];
                picks[2]--;
            }
        }
        return answer;
    }
}