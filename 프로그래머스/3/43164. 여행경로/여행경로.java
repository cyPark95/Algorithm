import java.util.*;

class Solution {

    static String[] answer;

    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        dfs(tickets, visited, "ICN", "ICN", 0);

        return answer;
    }

    private void dfs(String[][] tickets, boolean[] visited, String destination, String route, int L) {
        if (L == tickets.length) {
            if (answer == null) {
                answer = route.split(",");
            }

            String collect = String.join(",", answer);
            if (collect.compareTo(route) > 0) {
                answer = route.split(",");
            }
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && destination.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets, visited, tickets[i][1], route + "," + tickets[i][1], L + 1);
                visited[i] = false;
            }
        }
    }
}