import java.util.*;

class Solution {

    private static int[] dy = { -1, 0, 1, 0 };
    private static int[] dx = { 0, 1, 0, -1 };
    
    public int solution(int[][] land) {
        int answer = 0;
        int height = land.length;
        int width = land[0].length;

        boolean[][] visited = new boolean[height][width];
        int[] oils = new int[width];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (land[y][x] == 0 || visited[y][x]) {
                    continue;
                }

                int size = 0;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{ y, x });
                visited[y][x] = true;

                while (!q.isEmpty()) {
                    size++;
                    int[] current = q.poll();
                    min = Math.min(min, current[1]);
                    max = Math.max(max, current[1]);

                    for (int i = 0; i < 4; i++) {
                        int ny = current[0] + dy[i];
                        int nx = current[1] + dx[i];

                        if (ny >= 0 && ny < height && nx >= 0 && nx < width) {
                            if (land[ny][nx] == 1 && !visited[ny][nx]) {
                                visited[ny][nx] = true;
                                q.offer(new int[]{ ny, nx });
                            }
                        }
                    }
                }

                for (int i = min; i <= max; i++) {
                    oils[i] += size;
                }
            }
        }

        for (int oil : oils) {
            answer = Math.max(answer, oil);
        }

        return answer;
    }
}