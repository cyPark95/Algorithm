class Solution {

    static int answer, len;

    static int[] dy = {0, -1, 0, 1, 0};
    static int[] dx = {0, 0, 1, 0, -1};

    public int solution(int[][] clockHands) {
        answer = Integer.MAX_VALUE;
        len = clockHands.length;

        dfs(clockHands, 0, 0, 0);
        return answer;
    }

    private void dfs(int[][] clockHands, int row, int col, int count) {
        if (col == len) {
            int[][] map = clone(clockHands);
            count += getRotateCount(map);

            if (checked(map)) {
                answer = Math.min(answer, count);
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            rotate(clockHands, row, col);
            dfs(clockHands, row, col + 1, count + (i % 4));
        }
    }

    private int[][] clone(int[][] clockHands) {
        int[][] map = new int[len][];
        for (int row = 0; row < len; row++) {
            map[row] = clockHands[row].clone();
        }

        return map;
    }

    private int getRotateCount(int[][] map) {
        int count = 0;
        for (int row = 1; row < len; row++) {
            for (int col = 0; col < len; col++) {
                int rotateCount = (4 - map[row - 1][col]) % 4;
                for (int i = 0; i < rotateCount; i++) {
                    count++;
                    rotate(map, row, col);
                }
            }
        }

        return count;
    }

    private boolean checked(int[][] map) {
        for (int[] row : map) {
            for (int clockHand : row) {
                if (clockHand != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void rotate(int[][] map, int y, int x) {
        for (int i = 0; i < 5; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < len && nx >= 0 && nx < len) {
                map[ny][nx] = (map[ny][nx] + 1) % 4;
            }
        }
    }
}