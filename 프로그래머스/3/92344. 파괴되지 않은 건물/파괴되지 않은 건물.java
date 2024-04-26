class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int height = board.length;
        int width = board[0].length;

        int[][] prefixSum = new int[height + 1][width + 1];
        for (int[] round : skill) {
            int degree = round[5] * (round[0] == 1 ? -1 : 1);
            int[] start = new int[]{round[1], round[2]};
            int[] end = new int[]{round[3], round[4]};

            prefixSum[start[0]][start[1]] += degree;
            prefixSum[start[0]][end[1] + 1] -= degree;
            prefixSum[end[0] + 1][start[1]] -= degree;
            prefixSum[end[0] + 1][end[1] + 1] += degree;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 1; j < width; j++) {
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 1; j < height; j++) {
                prefixSum[j][i] += prefixSum[j - 1][i];
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] + prefixSum[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}