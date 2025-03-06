import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        int index = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
    
        while(index < truck_weights.length) {
            answer++;
            totalWeight -= q.poll();

            if(totalWeight + truck_weights[index] <= weight) {
                q.add(truck_weights[index]);
                totalWeight += truck_weights[index];
                index++;
            } else {
                q.add(0);
            }
        }

        return answer + bridge_length;
    }
}