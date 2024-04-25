import java.util.Arrays;

class Solution {

    private int[][] dp;

    public int[] solution(int target) {
        dp = new int[target + 1][2];
        for (int i = 1; i <= target; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        dp[0][1] = 0;

        for (int score = 1; score <= target; score++) {
            for (int dart = 1; dart <= 20; dart++) {
                updateScore(score, dart, 1);
                updateScore(score, dart * 2, 0);
                updateScore(score, dart * 3, 0);
            }

            if (score >= 50) {
                updateScore(score, 50, 1);
            }
        }

        return dp[target];
    }

    private void updateScore(int score, int dart, int addCount) {
        int prev = score - dart;

        if (prev >= 0) {
            if (dp[score][0] > dp[prev][0]) {
                dp[score][0] = dp[prev][0] + 1;
                dp[score][1] = dp[prev][1] + addCount;
            } else if (dp[score][0] == dp[prev][0]) {
                dp[score][1] = Math.min(dp[score][1], dp[prev][1] + addCount);
            }
        }
    }
}