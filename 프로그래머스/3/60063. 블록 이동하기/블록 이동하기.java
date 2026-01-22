import java.util.*;

class Solution {


    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    boolean[][][] visited;
    int N;

    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        visited = new boolean[N][N][4];

        Queue<Robot> q = new LinkedList<>();

        visited[0][0][1] = true;
        visited[0][1][3] = true;
        q.offer(new Robot(0, 0, 1, 0));
        q.offer(new Robot(0, 1, 3, 0));

        while (!q.isEmpty()) {
            Robot now = q.poll();

            if (now.row == N - 1 && now.col == N - 1) {
                answer = now.count;
                break;
            }

            int otherRow = now.row + dr[now.direction];
            int otherCol = now.col + dc[now.direction];

            for (int i = 0; i < 4; i++) {
                int dRow1 = now.row + dr[i];
                int dCol1 = now.col + dc[i];
                int dRow2 = otherRow + dr[i];
                int dCol2 = otherCol + dc[i];

                if (!in(dRow1, dCol1) || !in(dRow2, dCol2)) continue;
                if (board[dRow1][dCol1] == 1 || board[dRow2][dCol2] == 1) continue;

                int dir1 = now.direction;
                int dir2 = (now.direction + 2) % 4;

                if (visited[dRow1][dCol1][dir1]) continue;
                if (visited[dRow2][dCol2][dir2]) continue;

                visited[dRow1][dCol1][dir1] = true;
                visited[dRow2][dCol2][dir2] = true;

                q.offer(new Robot(dRow1, dCol1, dir1, now.count + 1));
                q.offer(new Robot(dRow2, dCol2, dir2, now.count + 1));
            }

            for (int turn = -1; turn <= 1; turn += 2) {
                int dDir = (now.direction + turn + 4) % 4;

                int newRow = now.row + dr[dDir];
                int newCol = now.col + dc[dDir];

                int checkRow = otherRow + dr[dDir];
                int checkCol = otherCol + dc[dDir];

                if (!in(newRow, newCol) || !in(checkRow, checkCol)) continue;
                if (board[newRow][newCol] == 1) continue;
                if (board[checkRow][checkCol] == 1) continue;

                int pivotDir = dDir;
                int newDir = (dDir + 2) % 4;

                if (!visited[now.row][now.col][pivotDir]) {
                    visited[now.row][now.col][pivotDir] = true;
                    q.offer(new Robot(now.row, now.col, pivotDir, now.count + 1));
                }

                if (!visited[newRow][newCol][newDir]) {
                    visited[newRow][newCol][newDir] = true;
                    q.offer(new Robot(newRow, newCol, newDir, now.count + 1));
                }
            }
        }

        return answer;
    }
    private boolean in(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}

class Robot {
    int row, col, direction, count;

    public Robot(int row, int col, int direction, int count) {
        this.row = row;
        this.col = col;
        this.direction = direction;
        this.count = count;
    }
}