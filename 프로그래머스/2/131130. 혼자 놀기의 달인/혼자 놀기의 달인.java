import java.util.*;

class Solution {

    static boolean[] open;

    public int solution(int[] cards) {
        int answer = 0; 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        open = new boolean[cards.length + 1];

        for (int card : cards) {
            if (!open[card]) {
                pq.offer(dfs(cards, card));
            }
        }

        if(pq.size() > 1) {
            answer = pq.poll() * pq.poll();
        }

        return answer;
    }

    private int dfs(int[] cards, int n) {
        if (open[n]) {
            return 0;
        }

        open[n] = true;
        return dfs(cards, cards[n - 1]) + 1;
    }
}