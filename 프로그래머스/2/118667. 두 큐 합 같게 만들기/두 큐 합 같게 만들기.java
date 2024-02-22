import java.util.*;

class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long leftTotal = 0L;
        Queue<Integer> leftQueue = new LinkedList<>();

        long rightTotal = 0L;
        Queue<Integer> rightQueue = new LinkedList<>();

        int len = queue1.length;
        for (int i = 0; i < len; i++) {
            leftTotal += queue1[i];
            leftQueue.offer(queue1[i]);

            rightTotal += queue2[i];
            rightQueue.offer(queue2[i]);
        }
        
        if((leftTotal + rightTotal) % 2 > 0) {
            return -1;
        }

        int count = 0;
        while (count < len * 4) {
            if(leftQueue.isEmpty() || rightQueue.isEmpty()) {
                return -1;
            }
            
            if (leftTotal > rightTotal) {
                int number = leftQueue.poll();
                leftTotal -= number;
                rightTotal += number;
                rightQueue.offer(number);
            } else if (leftTotal < rightTotal) {
                int number = rightQueue.poll();
                leftTotal += number;
                rightTotal -= number;
                leftQueue.offer(number);
            } else {
                return count;
            }
            
            count++;
        }

        return -1;
    }
}