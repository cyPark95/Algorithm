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
            visit(wire[0], wire[1]);
            answer = Math.min(answer, Math.abs((2 * dfs(graph, 1)) - n));
        }

        return answer;
    }

    private int dfs(List<List<Integer>> graph, int n) {
        int count = 1;
        for (int node : graph.get(n)) {
            if (!visited[n][node]) {
                visit(n, node);
                count += dfs(graph, node);
            }
        }

        return count;
    }

    private void visit(int v1, int v2) {
        visited[v1][v2] = true;
        visited[v2][v1] = true;
    }
}