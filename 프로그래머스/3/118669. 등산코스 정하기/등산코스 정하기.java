import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[]{0, Integer.MAX_VALUE};

        Set<Integer> gateSet = createSet(gates);
        Set<Integer> summitSet = createSet(summits);

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            if (!gateSet.contains(path[1]) && !summitSet.contains(path[0])) {
                graph.get(path[0]).add(new int[]{path[1], path[2]});
            }

            if (!gateSet.contains(path[0]) && !summitSet.contains(path[1])) {
                graph.get(path[1]).add(new int[]{path[0], path[2]});
            }
        }

        Arrays.sort(summits);
        int[] costs = bfs(n, gates, graph);
        for (int summit : summits) {
            if (answer[1] > costs[summit]) {
                answer[0] = summit;
                answer[1] = costs[summit];
            }
        }

        return answer;
    }

    private Set<Integer> createSet(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }

        return set;
    }

    private int[] bfs(int n, int[] gates, List<List<int[]>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        for (int gate : gates) {
            q.offer(new int[]{gate, 0});
            dist[gate] = 0;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] next : graph.get(cur[0])) {
                int cost = Math.max(cur[1], next[1]);

                if (cost < dist[next[0]]) {
                    dist[next[0]] = cost;
                    q.offer(new int[]{next[0], cost});
                }
            }
        }

        return dist;
    }
}