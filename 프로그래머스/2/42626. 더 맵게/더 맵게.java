import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int score : scoville) {
            pq.offer(score);
        }

        while (!pq.isEmpty()) {
            if (pq.peek() >= K) {
                break;
            }

            if (pq.size() < 2) {
                answer = -1;
                break;
            }

            int firstFood = pq.poll();
            int secondFood = pq.poll();
            int newScoville = firstFood + (secondFood * 2);

            pq.offer(newScoville);
            answer++;
        }

        return answer;
    }
}