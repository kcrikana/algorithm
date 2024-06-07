import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int[] parent = new int[n+1];
        int cost = 0;
        for(int i=0; i<=n; i++) parent[i] = i;
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        for(int i=0; i<costs.length; i++) {
            if(findSet(parent, costs[i][0]) != findSet(parent,costs[i][1])) {
                cost += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }
        return cost;
    }
    
    int findSet(int[] parent, int num) {
        if(parent[num] == num) return num;
        else return findSet(parent, parent[num]);
    }
    
    void union(int[] parent, int x, int y) {
        x = findSet(parent, x);
        y = findSet(parent, y);
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
}