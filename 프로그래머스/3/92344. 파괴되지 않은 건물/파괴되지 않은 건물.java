class Solution {
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        int height = board.length;
        int width = board[0].length;

        int[][] map = new int[height + 1][width + 1];
        for (int[] skill : skills) {
            int[] start = new int[]{skill[1], skill[2]};
            int[] end = new int[]{skill[3], skill[4]};
            int degree = skill[5] * (skill[0] == 1 ? -1 : 1);

            map[start[0]][start[1]] += degree;
            map[start[0]][end[1] + 1] -= degree;
            map[end[0] + 1][start[1]] -= degree;
            map[end[0] + 1][end[1] + 1] += degree;
        }

        for (int row = 0; row < height; row++) {
            for (int col = 1; col < width; col++) {
                map[row][col] += map[row][col - 1];
            }
        }

        for (int col = 0; col < height; col++) {
            for (int row = 1; row < width; row++) {
                map[row][col] += map[row - 1][col];
            }
        }

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (board[row][col] + map[row][col] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}