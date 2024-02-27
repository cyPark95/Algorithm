class Solution {

    static int score;
    static int[] answer = {-1};
    static int[] ryanBoard = new int[11];

    public int[] solution(int n, int[] info) {
        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            if (info[i] > 0) {
                sum += (10 - i);
            }
        }

        dfs(n, info, sum, 0, 0);
        return answer;
    }

    private void dfs(int n, int[] info, int apeach, int ryan, int L) {
        if (L == 10) {
            ryanBoard[10] = n;
            if (ryan - apeach > score) {
                score = ryan - apeach;
                answer = ryanBoard.clone();
            } else if (ryan - apeach == score) {
                answer = minBoard();
            }
            return;
        }

        dfs(n, info, apeach, ryan, L + 1);

        if (n > info[L]) {
            if (info[L] > 0) {
                apeach -= (10 - L);
            }

            ryanBoard[L] = info[L] + 1;
            dfs(n - (info[L] + 1), info, apeach, ryan + (10 - L), L + 1);
            ryanBoard[L] = 0;
        }
    }

    private int[] minBoard() {
        if(answer.length == 1) {
            return answer;
        }

        for (int i = 10; i >= 0; i--) {
            if (answer[i] > ryanBoard[i]) {
                return answer;
            } else if (answer[i] < ryanBoard[i]) {
                break;
            }
        }
        return ryanBoard.clone();
    }
}