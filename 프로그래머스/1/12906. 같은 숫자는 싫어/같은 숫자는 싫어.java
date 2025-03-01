import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int num : arr) {
            if(stack.isEmpty()) {
                stack.push(num);
                continue;
            }
            
            if(stack.peek() == num) {
                continue;
            }
            
            stack.push(num);
        }
        
        return stack.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}