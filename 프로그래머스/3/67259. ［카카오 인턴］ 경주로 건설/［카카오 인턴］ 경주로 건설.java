import java.util.*;

class Solution {
    public int solution(int[][] board) {
        return bfs(board);
    }

    private int bfs(int[][] board) {
        int N = board.length;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int[][][] cost = new int[N][N][4];
        for (int[][] row : cost) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Road> q = new PriorityQueue<>();
        q.add(new Road(0, 0, 1, 0));
        cost[0][0][1] = 0;
        q.add(new Road(0, 0, 2, 0));
        cost[0][0][2] = 0;

        while (!q.isEmpty()) {
            Road cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[ny][nx] == 0) {
                    int newCost = cur.cost + 100;
                    if (cur.direction != d) {
                        newCost += 500;
                    }

                    if (cost[ny][nx][cur.direction] >= newCost) {
                        cost[ny][nx][cur.direction] = newCost;
                        q.add(new Road(nx, ny, d, newCost));
                    }
                }
            }
        }

        return Arrays.stream(cost[N - 1][N - 1])
                .min()
                .orElseThrow();
    }

    static class Road implements Comparable<Road> {
        int x;
        int y;
        int direction;
        int cost;

        Road(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return cost - o.cost;
        }
    }
}