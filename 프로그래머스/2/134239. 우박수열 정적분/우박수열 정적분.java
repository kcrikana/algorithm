import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(k);
        while(k != 1) {
            if(k%2 == 0) k/=2;
            else k=k*3+1;
            arr.add(k);
        }
        ArrayList<Double> res = new ArrayList<>();
        for(int i=0; i<arr.size()-1; i++) {
            double maxNum = Math.max(arr.get(i),arr.get(i+1));
            double minNum = Math.min(arr.get(i),arr.get(i+1));
            double result = minNum+(maxNum-minNum)/2;
            res.add(result);
        }
        double[] answer = new double[ranges.length];
        for(int i=0; i<ranges.length; i++) {
            int a = ranges[i][0];
            int b = arr.size()+ranges[i][1];
            if(a>=b) answer[i] = -1.0;
            else {
                double result = 0;
                for(int j=a; j<b-1; j++) result += res.get(j);
                answer[i] = result;
            }
        }
        return answer;
    }
}