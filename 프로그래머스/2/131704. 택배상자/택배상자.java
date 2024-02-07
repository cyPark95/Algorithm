import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        int idx = 0;
        int len = order.length;
        for (int i = 1; i <= len; i++) {
            stack.push(i);

            while(!stack.isEmpty() && stack.peek() == order[idx]) {
                idx++;
                answer++;
                stack.pop();
            }
        }

        return answer;
    }
}