import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int result = 9*10/2;
        int sum = 0;
        for(int i=0; i<numbers.length; i++) sum += numbers[i];
        return result-sum;
    }
}