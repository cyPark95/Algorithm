import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long max = Arrays.stream(times)
            .max()
            .orElse(0);

        long left = 0;
        long right = max * n;

        while (left <= right) {
            long mid = (left + right) / 2;

            long people = 0;
            for (int time : times) {
                people += mid / time;

                if (people >= n) {
                    break;
                }
            }

            if (people >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}