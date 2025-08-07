class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] isPass = new boolean[m + 1][n + 1];
        isPass[1][1] = true;
        for (int[] puddle : puddles) {
            isPass[puddle[0]][puddle[1]] = true;
        }

        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (isPass[i][j]) {
                    continue;
                }

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007;
            }
        }

        return dp[m][n];
    }
}