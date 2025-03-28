import java.util.*;

class Solution {

    static boolean[][] visited;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        for (int[] wire : wires) {
            visited = new boolean[n + 1][n + 1];
            visited[wire[0]][wire[1]] = true;
            visited[wire[1]][wire[0]] = true;
            int count = dfs(graph, 1);
            
            int result = (2 * count) - n;
            answer = Math.min(answer, Math.abs(result));
        }

        return answer;
    }

    private int dfs(List<List<Integer>> graph, int n) {
        int count = 1;
        for (int node : graph.get(n)) {
            if (!visited[n][node]) {
                visited[n][node] = true;
                visited[node][n] = true;
                count += dfs(graph, node);
            }
        }

        return count;
    }
}