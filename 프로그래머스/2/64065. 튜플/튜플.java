import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] split = s.split("},\\{");
        Arrays.sort(split, (s1, s2) -> s1.length() - s2.length());

        int[] answer = new int[split.length];
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < split.length; i++) {
            String[] numbers = split[i].split(",");
            
            for(String number : numbers) {
                int num = Integer.parseInt(number);

                if (set.add(num)) {
                    answer[i] = num;
                    break;
                }
            }
        }

        return answer;
    }
}