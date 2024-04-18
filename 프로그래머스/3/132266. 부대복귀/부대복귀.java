import java.util.*;

class Solution {

    static int[] cost;
    static List<List<Integer>> graph;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        cost = new int[n + 1];
        Arrays.fill(cost, -1);

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        bfs(destination);

        for (int i = 0; i < sources.length; i++) {
            answer[i] = cost[sources[i]];
        }

        return answer;
    }

    private void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        cost[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (cost[next] == -1) {
                    cost[next] = cost[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}