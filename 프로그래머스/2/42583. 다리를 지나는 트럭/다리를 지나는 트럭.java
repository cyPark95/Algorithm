import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q  = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;
        int index = 0;

        while (index < truck_weights.length || !q.isEmpty()) {
            if (!q.isEmpty() && q.peek() <= time) {
                totalWeight -= truck_weights[index - q.size()];
                q.poll();
            }

            if (index < truck_weights.length && totalWeight + truck_weights[index] <= weight) {
                q.offer(time + bridge_length);
                totalWeight += truck_weights[index];
                index++;
            } else if (!q.isEmpty()) {
                time = q.peek() - 1;
            }

            time++;
        }

        return time;
    }
}