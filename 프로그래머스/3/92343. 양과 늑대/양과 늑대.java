import java.util.*;

class Solution {

    static int answer;
    static List<List<Integer>> graph;

    public int solution(int[] info, int[][] edges) {
        graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        List<Integer> next = new ArrayList<>();
        next.add(0);

        dfs(info, next, 0, 0, 0);
        return answer;
    }

    private void dfs(int[] info, List<Integer> list, int index, int sheepCount, int wolfCount) {
        if (info[index] == 0) {
            sheepCount++;
        } else {
            wolfCount++;
        }

        if (wolfCount >= sheepCount) {
            return;
        }

        answer = Math.max(answer, sheepCount);

        List<Integer> next = new ArrayList<>(list);
        next.remove(Integer.valueOf(index));
        if (!graph.get(index).isEmpty()) {
            next.addAll(graph.get(index));
        }

        for (Integer n : next) {
            dfs(info, next, n, sheepCount, wolfCount);
        }
    }
}