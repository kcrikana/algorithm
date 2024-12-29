import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        HashMap<Character, Integer> directionMap = new HashMap<>();
        directionMap.put('U', 0);
        directionMap.put('D', 1);
        directionMap.put('L', 2);
        directionMap.put('R', 3);
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int row = 0;
        int col = 0;
        for(char ch : dirs.toCharArray()) {
            sb.setLength(0);
            int direction = directionMap.get(ch);
            int dRow = row + dr[direction];
            int dCol = col + dc[direction];
            if(dRow < -5 || dCol < -5 || dRow > 5 || dCol > 5) continue;
            sb.append(Math.max(dRow,row)).append(Math.max(dCol,col)).append(Math.min(dRow,row)).append(Math.min(dCol,col));
            set.add(sb.toString());
            row = dRow;
            col = dCol;
        }
        return set.size();
    }
}