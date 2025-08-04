import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(n -> n[1]));

        int end = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (end < route[0]) {
                end = route[1];
                answer++;
            }
        }

        return answer;
    }
}