import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        int half = len/2;
        for(int num : nums) set.add(num);
        if(half>=set.size()) return set.size();
        else return half;
    }
}