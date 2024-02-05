import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        values.sort(Collections.reverseOrder());

        int sum = 0;
        for(int value : values) {
            answer++;
            sum += value;

            if(sum >= k) {
                break;
            }
        }

        return answer;
    }
}