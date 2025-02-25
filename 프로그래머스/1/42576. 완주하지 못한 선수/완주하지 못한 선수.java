import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> runners = new HashMap<>();
        for(String runner : participant) {
            runners.put(runner, runners.getOrDefault(runner, 0) + 1);
        }
        
        for(String runner : completion) {
            runners.put(runner, runners.get(runner) - 1);
        }
        
        for(String key : runners.keySet()) {
            if(runners.get(key) > 0) {
                return key;
            }
        }
        
        return "";
    }
}