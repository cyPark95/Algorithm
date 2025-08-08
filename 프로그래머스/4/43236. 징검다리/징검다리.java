import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int[] gaps = new int[rocks.length + 1];
        int previous = 0;
        for (int i = 0; i < rocks.length; i++) {
            gaps[i] = rocks[i] - previous;
            previous = rocks[i];
        }
        gaps[rocks.length] = distance - previous;

        int left = 0;
        int right = distance;
        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            int count = 0;
            for (int gap : gaps) {
                sum += gap;

                if (sum < mid) {
                    count++;
                    continue;
                }

                sum = 0;
            }

            if (count > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }
}