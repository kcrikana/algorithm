import java.util.*;

class Solution {

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        int threat = 0;
        int[][] visited = new int[101][101];

        for (int[] route : routes) {
            int row = points[route[0] - 1][0];
            int col = points[route[0] - 1][1];
            q.offer(new Node(row, col, 1, route));
            visited[row][col]++;
            if (visited[row][col] == 2) threat++;
        }

        answer += threat;
        int cycle = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            visited[now.row][now.col]--;
            if (visited[now.row][now.col] == 1) threat--;

            if (now.row == points[now.route[now.target - 1] - 1][0] &&
                now.col == points[now.route[now.target - 1] - 1][1]) {

                if (now.target < now.route.length) {
                    cycle++;
                    int nextPoint = now.route[now.target];
                    int[] next = find(now.row, now.col, points[nextPoint - 1][0], points[nextPoint - 1][1]);
                    visited[next[0]][next[1]]++;
                    if (visited[next[0]][next[1]] == 2) threat++;
                    q.offer(new Node(next[0], next[1], now.target + 1, now.route));
                }
            } else {
                cycle++;
                int targetPoint = now.route[now.target - 1];
                int[] next = find(now.row, now.col, points[targetPoint - 1][0], points[targetPoint - 1][1]);
                visited[next[0]][next[1]]++;
                if (visited[next[0]][next[1]] == 2) threat++;
                q.offer(new Node(next[0], next[1], now.target, now.route));
            }

            if (cycle == q.size()) {
                cycle = 0;
                answer += threat;
            }
        }

        return answer;
    }

    int[] find(int nowRow, int nowCol, int targetRow, int targetCol) {
        int[] arr = new int[2];
        arr[0] = nowRow;
        arr[1] = nowCol;
        if (nowRow == targetRow) arr[1] = nowCol > targetCol ? arr[1] - 1 : arr[1] + 1;
        else arr[0] = nowRow > targetRow ? arr[0] - 1 : arr[0] + 1;
        return arr;
    }
}

class Node {
    int[] route;
    int row, col, target;

    public Node(int row, int col, int target, int[] route) {
        this.row = row;
        this.col = col;
        this.target = target;
        this.route = route;
    }
}
