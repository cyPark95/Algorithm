import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        int[] numbers = new int[n];
        String[] operators = new String[arr.length - n];

        int numberIndex = 0;
        int operatorIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                numbers[numberIndex++] = Integer.parseInt(arr[i]);
            } else {
                operators[operatorIndex++] = arr[i];
            }
        }

        int[][] max = new int[n][n];
        int[][] min = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            max[i][i] = numbers[i];
            Arrays.fill(min[i], Integer.MAX_VALUE);
            min[i][i] = numbers[i];
        }

        for (int length = 1; length < n; length++) {
            for (int start = 0; start < n - length; start++) {
                int end = length + start;

                for(int split = start; split < end; split++) {
                    if (operators[split].equals("+")) {
                        max[start][end] = Math.max(max[start][end], max[start][split] + max[split + 1][end]);
                        min[start][end] = Math.min(min[start][end], min[start][split] + min[split + 1][end]);
                    } else {
                        max[start][end] = Math.max(max[start][end], max[start][split] - min[split + 1][end]);
                        min[start][end] = Math.min(min[start][end], min[start][split] - max[split + 1][end]);
                    }
                }
            }
        }

        return max[0][n - 1];
    }
}