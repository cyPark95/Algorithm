import java.util.*;

class Solution {

    static Map<String, List<Integer>> infoCase;

    public int[] solution(String[] info, String[] query) {
        int len = query.length;
        int[] answer = new int[len];

        infoCase = new HashMap<>();
        for (String s : info) {
            String[] split = s.split(" ");
            dfs(split, "", 0);
        }

        for (List<Integer> values : infoCase.values()) {
            Collections.sort(values);
        }

        for (int i = 0; i < len; i++) {
            String[] querySplit = query[i].split(" ");
            String key = querySplit[0] + querySplit[2] + querySplit[4] + querySplit[6];

            List<Integer> scores = infoCase.get(key);
            if (scores != null) {
                int score = Integer.parseInt(querySplit[7]);
                answer[i] += binarySearch(scores, score);
            }
        }

        return answer;
    }

    private void dfs(String[] infoSplit, String key, int depth) {
        if (depth == 4) {
            List<Integer> score = infoCase.getOrDefault(key, new ArrayList<>());
            score.add(Integer.parseInt(infoSplit[4]));
            infoCase.put(key, score);
            return;
        }

        dfs(infoSplit, key + "-", depth + 1);
        dfs(infoSplit, key + infoSplit[depth], depth + 1);
    }
    
    private int binarySearch(List<Integer> scores, int score) {
        int left = 0;
        int right = scores.size() - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(scores.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return scores.size() - left;
    }
}