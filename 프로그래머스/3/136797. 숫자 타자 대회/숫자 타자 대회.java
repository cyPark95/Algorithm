class Solution {
    
    static int[][] button = {
            {3, 1},
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2},
    };
    static int[][] cost;
    static int[][][] dp;

    public int solution(String numbers) {
        int[] number = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            number[i] = numbers.charAt(i) - '0';
        }

        initCost();

        dp = new int[number.length][10][10];
        return find(number, 4, 6, 0);
    }

    private void initCost() {
        cost = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i == j) {
                    cost[i][j] = 1;
                    continue;
                }

                int row = Math.abs(button[i][0] - button[j][0]);
                int col = Math.abs(button[i][1] - button[j][1]);

                cost[i][j] = Math.max(row, col) * 2 + Math.min(row, col);
            }
        }
    }

    private int find(int[] numbers, int left, int right, int L) {
        if(L == numbers.length) {
            return 0;
        }

        if(dp[L][left][right] == 0) {
            int min = Integer.MAX_VALUE;
            if(numbers[L] != right) {
                min = find(numbers, numbers[L], right, L + 1) + cost[left][numbers[L]];
            }
            if(numbers[L] != left) {
                min = Math.min(min, find(numbers, left, numbers[L], L + 1) + cost[right][numbers[L]]);
            }

            dp[L][left][right] = min;
        }

        return dp[L][left][right];
    }
}