class Solution {

    static int answer, height, width;

    public int solution(int[][] beginning, int[][] target) {
        answer = Integer.MAX_VALUE;
        height = beginning.length;
        width = beginning[0].length;

        dfs(beginning, target, 0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int[][] map, int[][] target, int count, int row) {
        if (row == height) {
            for (int col = 0; col < width; col++) {
                int matchCount = matchColumn(map, target, col);

                if (matchCount > 0 && matchCount < height) {
                    return;
                }

                if (matchCount == height) {
                    count++;
                }
            }

            answer = Math.min(answer, count);
            return;
        }

        flipRow(map, row);
        dfs(map, target, count + 1, row + 1);

        flipRow(map, row);
        dfs(map, target, count, row + 1);
    }

    private int matchColumn(int[][] map, int[][] target, int col) {
        int count = 0;
        for (int row = 0; row < height; row++) {
            if (map[row][col] != target[row][col]) {
                count++;
            }
        }

        return count;
    }

    private void flipRow(int[][] map, int row) {
        for (int col = 0; col < width; col++) {
            map[row][col] = 1 - map[row][col];
        }
    }
}