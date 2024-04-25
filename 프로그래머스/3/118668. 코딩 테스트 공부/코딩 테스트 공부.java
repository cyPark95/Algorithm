class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int goalAlp = 0;
        int goalCop = 0;
        for (int[] problem : problems) {
            goalAlp = Math.max(goalAlp, problem[0]);
            goalCop = Math.max(goalCop, problem[1]);
        }

        if (alp >= goalAlp && cop >= goalCop) {
            return 0;
        }

        alp = Math.min(alp, goalAlp);
        cop = Math.min(cop, goalCop);

        int[][] dp = new int[goalAlp + 2][goalCop + 2];
        for (int i = alp; i <= goalAlp; i++) {
            for (int j = cop; j <= goalCop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[alp][cop] = 0;
        for (int a = alp; a <= goalAlp; a++) {
            for (int c = cop; c <= goalCop; c++) {
                dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);
                dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);

                for (int[] problem : problems) {
                    if (a >= problem[0] && c >= problem[1]) {
                        if(a + problem[2] > goalAlp && c + problem[3] > goalCop) {
                            dp[goalAlp][goalCop] = Math.min(dp[goalAlp][goalCop], dp[a][c] + problem[4]);
                        } else if(a + problem[2] > goalAlp) {
                            dp[goalAlp][c + problem[3]] = Math.min(dp[goalAlp][c + problem[3]], dp[a][c] + problem[4]);
                        } else if(c + problem[3] > goalCop) {
                            dp[a + problem[2]][goalCop] = Math.min(dp[a + problem[2]][goalCop], dp[a][c] + problem[4]);
                        } else {
                            dp[a + problem[2]][c + problem[3]] = Math.min(dp[a + problem[2]][c + problem[3]], dp[a][c] + problem[4]);
                        }
                    }
                }
            }
        }

        return dp[goalAlp][goalCop];
    }
}