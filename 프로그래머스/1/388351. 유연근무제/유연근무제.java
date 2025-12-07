class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int checkInTime = schedules[i] + 10;
            if(checkInTime % 100 >= 60) {
                checkInTime = checkInTime + 100 - 60;
            }

            if (isWorkOnTime(checkInTime, timelogs[i], startday)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isWorkOnTime(int adjustedStartTime, int[] timelogs, int startday) {
        for (int i = 0; i < timelogs.length; i++) {
            int currentDay = (startday + i - 1) % 7 + 1;
            if (currentDay == 6 || currentDay == 7) {
                continue;
            }

            if (adjustedStartTime < timelogs[i]) {
                return false;
            }
        }
        return true;
    }
}