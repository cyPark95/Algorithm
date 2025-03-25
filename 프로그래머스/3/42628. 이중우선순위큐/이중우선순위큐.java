import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (String operation : operations) {
            if (operation.startsWith("I")) {
                int num = Integer.parseInt(operation.split(" ")[1]);
                maxQueue.offer(num);
                minQueue.offer(num);
                continue;
            }

            if (maxQueue.isEmpty()) {
                continue;
            }

            if (operation.split(" ")[1].equals("1")) {
                minQueue.remove(maxQueue.poll());
            } else {
                maxQueue.remove(minQueue.poll());
            }
        }

        answer[0] = maxQueue.isEmpty() ? 0 : maxQueue.poll();
        answer[1] = minQueue.isEmpty() ? 0 : minQueue.poll();

        return answer;
    }
}