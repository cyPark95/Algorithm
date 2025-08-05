import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<List<Integer>> winnerGraph = new ArrayList<>();
        List<List<Integer>> loserGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            winnerGraph.add(new ArrayList<>());
            loserGraph.add(new ArrayList<>());
        }

        for (int[] result : results) {
            winnerGraph.get(result[0]).add(result[1]);
            loserGraph.get(result[1]).add(result[0]);
        }

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];

            int winnerCount = dfs(winnerGraph, visited, i);
            int loserCount = dfs(loserGraph, visited, i);

            if (winnerCount + loserCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private int dfs(List<List<Integer>> graph, boolean[] visited, int current) {
        int count = 0;
        visited[current] = true;

        for (Integer next : graph.get(current)) {
            if (!visited[next]) {
                count += 1 + dfs(graph, visited, next);
            }
        }

        return count;
    }
}