import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        if(Arrays.stream(words).noneMatch(word -> word.equals(target))){
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(begin);

        boolean[] visited = new boolean[words.length];
        while (!q.isEmpty()) {
            answer++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String current = q.poll();

                for (int j = 0; j < words.length; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    if (isOneCharDifferent(words[j], current)) {
                        if (words[j].equals(target)) {
                            return answer;
                        }

                        visited[j] = true;
                        q.offer(words[j]);
                    }
                }
            }
        }

        return 0;
    }

    private boolean isOneCharDifferent(String word, String target) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}