import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        for (int number : stack) {
            answer[number] = -1;
        }

        return answer;
    }
}