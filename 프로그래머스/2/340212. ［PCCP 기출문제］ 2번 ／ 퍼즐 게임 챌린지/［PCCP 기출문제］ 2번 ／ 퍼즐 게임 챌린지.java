class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 0;
        for (int diff : diffs) {
            right = Math.max(right, diff);
        }
        
        while (left < right) {
            int level = (left + right) / 2;
            long time = times[0];

            for (int i = 1; i < diffs.length; i++) {
                if (level >= diffs[i]) {
                    time += times[i];
                } else {
                    int failCount = diffs[i] - level;
                    time += (long) failCount * (times[i - 1] + times[i]) + times[i];
                }

                if (time > limit) break;
            }

            if (time <= limit) {
                right = level;
            } else {
                left = level + 1;
            }
        }

        return right;
    }
}