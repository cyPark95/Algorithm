class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            int count = checkedMap(m, n, map);
            if (count == 0) {
                break;
            }

            answer += count;
            rearrangeMap(m, n, map);
        }
        return answer;
    }

    private int checkedMap(int m, int n, char[][] map) {
        boolean[][] removeBlock = new boolean[m][n];
        for (int y = 0; y < m - 1; y++) {
            for (int x = 0; x < n - 1; x++) {
                if (isRemovable(y, x, map)) {
                    removeBlock[y][x] = true;
                    removeBlock[y + 1][x] = true;
                    removeBlock[y][x + 1] = true;
                    removeBlock[y + 1][x + 1] = true;
                }
            }
        }

        return removeBlock(m, n, map, removeBlock);
    }

    private boolean isRemovable(int y, int x, char[][] map) {
        return map[y][x] != '-' && map[y][x] == map[y + 1][x] && map[y][x] == map[y][x + 1] && map[y][x] == map[y + 1][x + 1];
    }

    private int removeBlock(int m, int n, char[][] map, boolean[][] remove) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (remove[i][j]) {
                    count++;
                    map[i][j] = '-';
                }
            }
        }

        return count;
    }

    private void rearrangeMap(int m, int n, char[][] map) {
        for (int x = 0; x < n; x++) {
            for (int y = 1; y < m; y++) {
                if (map[y][x] == '-') {
                    for (int i = y - 1; i >= 0; i--) {
                        if (map[i][x] == '-') {
                            break;
                        }

                        map[i + 1][x] = map[i][x];
                        map[i][x] = '-';
                    }
                }
            }
        }
    }
}