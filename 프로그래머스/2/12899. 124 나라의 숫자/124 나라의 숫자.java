class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            int num = n%3;
            int min = 0;
            if(num == 1) sb.append(1);
            else if(num == 2) sb.append(2);
            else {
                sb.append(4);
                min = -1;
            }
            n /= 3;
            n += min;
        }
        sb.reverse();
        return sb.toString();
    }
}