import java.util.*;

class Solution {

    int max;
    static Map<String, Integer> count;

    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int size : course) {
            max = 0;
            count = new HashMap<>();
            for (String order : orders) {
                char[] sortOrder = order.toCharArray();
                Arrays.sort(sortOrder);
                dfs(sortOrder, size, "", 0);
            }

            if (max < 2) {
                continue;
            }

            count.keySet().stream()
                    .filter(key -> count.get(key) == max)
                    .forEach(answer::add);
        }

        Collections.sort(answer);
        return answer;
    }

    private void dfs(char[] order, int size, String course, int idx) {
        if (course.length() == size) {
            count.put(course, count.getOrDefault(course, 0) + 1);
            max = Math.max(max, count.get(course));
            return;
        }

        for (int i = idx; i < order.length; i++) {
            dfs(order, size, course + order[i], i + 1);
        }
    }
}