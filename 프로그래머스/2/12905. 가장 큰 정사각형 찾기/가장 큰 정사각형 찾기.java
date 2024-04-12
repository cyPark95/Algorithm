class Solution{
    public int solution(int [][]board){
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        int[][] map = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            System.arraycopy(board[i], 0, map[i + 1], 1, col);
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                map[i][j] = Math.min(map[i - 1][j - 1], Math.min(map[i - 1][j], map[i][j - 1])) + 1;
                answer = Math.max(answer, map[i][j]);
            }
        }

        return (int) Math.pow(answer, 2);
    }
}