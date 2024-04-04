import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remainProgress = 100 - progresses[i];
            int remainDays = (remainProgress + speeds[i] - 1) / speeds[i];
            q.offer(remainDays);
        }

        while (!q.isEmpty()) {
            int count = 1;
            int day = q.poll();

            while (!q.isEmpty() && q.peek() <= day) {
                q.poll();
                count++;
            }

            answer.add(count);
        }

        return answer;
    }
}