import java.util.*;

class Solution {

    static int answer;
    static List<List<Integer>> graph;

    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : lighthouse) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(1, 0);
        return answer;
    }

    private int dfs(int node, int before) {
        if(graph.get(node).size() == 1 && graph.get(node).get(0) == before) {
            return 1;
        }

        int count = 0;
        for(int next : graph.get(node)) {
            if(next == before) {
                continue;
            }

            count += dfs(next, node);
        }

        if (count == 0) {
            return 1;
        }

        answer++;
        return 0;
    }
}