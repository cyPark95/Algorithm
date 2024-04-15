import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
    }

    private int bfs(int[][] maps) {
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        int row = maps.length;
        int col = maps[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int L = 1;

        while (!q.isEmpty()) {
            L++;
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = cur[0] + dy[j];
                    int nx = cur[1] + dx[j];

                    if (ny == row - 1 && nx == col - 1) {
                        return L;
                    }

                    if (ny >= 0 && ny < row && nx >= 0 && nx < col) {
                        if (maps[ny][nx] == 0) {
                            continue;
                        }
                        
                        maps[ny][nx] = 0;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }

        return -1;
    }
}