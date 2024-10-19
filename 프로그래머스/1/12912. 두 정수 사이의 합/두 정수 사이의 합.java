class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        answer = (long)(max-min+1)*(max+min)/2;
        return answer;
    }
}