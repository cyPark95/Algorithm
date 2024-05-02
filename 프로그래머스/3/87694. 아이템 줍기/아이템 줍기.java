import java.util.*;

class Solution {

    static int[][] map;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];
        for (int[] cur : rectangle) {
            fill(cur[0] * 2, cur[1] * 2, cur[2] * 2, cur[3] * 2);
        }

        return bfs(new int[]{characterY * 2, characterX * 2}, new int[]{itemY * 2, itemX * 2});
    }

    private void fill(int x1, int y1, int x2, int y2) {
        for (int row = y1; row <= y2; row++) {
            for (int col = x1; col <= x2; col++) {
                if (map[row][col] == 2) {
                    continue;
                }
                
                map[row][col] = 2;
                if (row == y1 || row == y2 || col == x1 || col == x2) {
                    map[row][col] = 1;
                }
            }
        }
    }

    private int bfs(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];

        q.offer(start);
        visited[start[0]][start[1]] = true;
        int L = 0;

        while (!q.isEmpty()) {
            L++;

            int len = q.size();
            for(int i=0; i<len; i++) {
                int[] cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = cur[0] + dy[j];
                    int nx = cur[1] + dx[j];

                    if (ny == end[0] && nx == end[1]) {
                        return L / 2;
                    }

                    if (ny >= 0 && ny < 102 && nx >= 0 && ny < 102 ) {
                        if (!visited[ny][nx] && map[ny][nx] == 1) {
                            visited[ny][nx] = true;
                            q.offer(new int[]{ny, nx});
                        }
                    }
                }
            }
        }

        return -1;
    }
}