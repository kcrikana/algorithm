import java.util.*;
public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n > 0) {
            int num = n%2;
            if(num == 1) ans++;
            n /= 2;
        }
        return ans;
    }
}