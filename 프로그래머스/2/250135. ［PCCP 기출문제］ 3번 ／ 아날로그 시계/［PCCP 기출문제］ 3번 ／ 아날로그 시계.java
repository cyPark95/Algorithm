class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        long start = h1 * 3600L + m1 * 60L + s1;
        long end = h2 * 3600L + m2 * 60L + s2;

        if (start == 0 || start == 12 * 3600) {
            answer++;
        }

        while (start < end) {
            double currentHourAngle = (start / 120.0) % 360;
            double currentMinuteAngle = (start / 10.0) % 360;
            double currentSecondAngle = (start * 6.0) % 360;

            double nextHourAngle = ((start + 1) / 120.0) % 360;
            if (nextHourAngle == 0) {
                nextHourAngle = 360;
            }

            double nextMinuteAngle = ((start + 1) / 10.0) % 360;
            if (nextMinuteAngle == 0) {
                nextMinuteAngle = 360;
            }

            double nextSecondAngle = ((start + 1) * 6.0) % 360;
            if (nextSecondAngle == 0) {
                nextSecondAngle = 360;
            }

            if (currentSecondAngle < currentHourAngle && nextSecondAngle >= nextHourAngle) {
                answer++;
            }
            if (currentSecondAngle < currentMinuteAngle && nextSecondAngle >= nextMinuteAngle) {
                answer++;
            }

            if (nextHourAngle == nextMinuteAngle && nextHourAngle == nextSecondAngle) {
                answer--;
            }

            start++;
        }

        return answer;
    }
}