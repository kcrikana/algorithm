import java.util.*;
class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = (long)(count*(count+1)/2)*(long)price;
        answer = sum - money;
        return answer < 0 ? 0 : answer;
    }
}