class Solution {

    static int height, width;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        height = board.length;
        width = board[0].length;

        User answer = dfs(board, aloc, bloc, true, 0);
        return answer.count;
    }

    private User dfs(int[][] board, int[] a, int[] b, boolean isATurn, int count) {
        int[] cur = isATurn ? a : b;

        if(board[cur[0]][cur[1]] == 0) {
            return new User(false, count);
        }

        board[cur[0]][cur[1]] = 0;

        int win = Integer.MAX_VALUE;
        int lose = 0;
        boolean canMove = false;

        for(int i=0; i<4; i++) {
            int ny = cur[0] + dy[i];
            int nx = cur[1] + dx[i];

            if(ny >= 0 && ny < height && nx >= 0 && nx < width && board[ny][nx] == 1) {
                canMove = true;

                User next;
                if(isATurn) {
                    next = dfs(board, new int[]{ny, nx}, b, !isATurn, count + 1);
                } else {
                    next = dfs(board, a, new int[]{ny, nx}, !isATurn, count + 1);
                }

                if(next.isWin) {
                    lose = Math.max(lose, next.count);
                } else {
                    win = Math.min(win, next.count);
                }
            }
        }

        board[cur[0]][cur[1]] = 1;

        if(!canMove) {
            return new User(false, count);
        }

        if(win < Integer.MAX_VALUE) {
            return new User(true, win);
        } else {
            return new User(false, lose);
        }
    }

    static class User {
        boolean isWin;
        int count;

        public User(boolean isWin, int count) {
            this.isWin = isWin;
            this.count = count;
        }
    }
}