import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            
            if(c == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            
            stack.push(c);
        }
        
        return stack.isEmpty();
    }
}