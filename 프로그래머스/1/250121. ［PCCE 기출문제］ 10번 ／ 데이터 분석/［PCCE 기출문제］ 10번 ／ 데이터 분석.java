import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        int val = map.get(ext);
        ArrayList<int []> list = new ArrayList<>();
        for(int[] engineer : data) {
            if(engineer[val] < val_ext) list.add(engineer);
        }
        int sort = map.get(sort_by);
        Collections.sort(list, (o1, o2) -> (o1[sort] - o2[sort]));
        int[][] answer = new int[list.size()][4];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}