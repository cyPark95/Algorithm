import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> typeCount = new HashMap<>();
        for(String[] type : clothes) {
            typeCount.put(type[1], typeCount.getOrDefault(type[1], 0) + 1);
        }
        
        for(String key : typeCount.keySet()) {
            answer *= (typeCount.get(key) + 1);
        }
        
        return answer - 1;
    }
}