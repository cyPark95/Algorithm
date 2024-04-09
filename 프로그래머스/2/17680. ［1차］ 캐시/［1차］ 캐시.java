
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        Set<String> cache = new LinkedHashSet<>();
        for (String city : cities) {
            city = city.toLowerCase();

            if (!cache.remove(city)) {
                if (cache.size() == cacheSize) {
                    cache.remove(cache.iterator().next());
                }
                answer += 4;
            }

            answer += 1;
            cache.add(city);
        }

        return answer;
    }
}