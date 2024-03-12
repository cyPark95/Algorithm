import java.util.*;

class Solution {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = checkPlace(places[i]);
        }

        return answer;
    }

    private int checkPlace(String[] place) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (place[y].charAt(x) == 'P') {
                    if (!isDiscount(place, y, x)) {
                        return 0;
                    }
                }
            }
        }

        return 1;
    }

    private boolean isDiscount(String[] place, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int j = 0; j < 4; j++) {
                int ny = cur[0] + dy[j];
                int nx = cur[1] + dx[j];

                if ((ny < 0 || ny >= 5 || nx < 0 || nx >= 5) || (ny == y && nx == x)) {
                    continue;
                }

                int distance = Math.abs(y - ny) + Math.abs(x - nx);

                if (place[ny].charAt(nx) == 'P' && distance <= 2) {
                    return false;
                } else if (place[ny].charAt(nx) == 'O' && distance < 2) {
                    q.offer(new int[]{ny, nx});
                }
            }
        }

        return true;
    }
}