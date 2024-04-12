import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : road) {
            graph.get(edge[0]).add(new Edge(edge[1], edge[2]));
            graph.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }

        int[] dist = bfs(graph, N);

        return (int) Arrays.stream(dist)
                .filter(cost -> cost <= K)
                .count();
    }

    private int[] bfs(List<List<Edge>> graph, int N) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0;
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            for (Edge next : graph.get(cur.node)) {
                if (cur.cost > dist[cur.node]) {
                    continue;
                }

                if (dist[next.node] > cur.cost + next.cost) {
                    dist[next.node] = cur.cost + next.cost;
                    pq.offer(new Edge(next.node, dist[next.node]));
                }
            }
        }

        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}