import java.util.*;

class Solution {

    static int answer;
    static boolean[] visited;
    static Set<Integer> set;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        set = new HashSet<>();

        dfs(numbers, "");
        return answer;
    }

    private void dfs(String numbers, String current) {
        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            if (set.add(num)) {
                if (isPrime(num)) {
                    answer++;
                }
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}