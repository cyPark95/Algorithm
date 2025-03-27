import java.util.*;

class Solution {
    
    private int answer;
    private boolean[] checked;
    
    public int solution(int k, int[][] dungeons) {
        checked = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    
    private void dfs(int L, int k, int[][] dungeons) {
        answer = Math.max(answer, L);
        
        for (int i = 0; i < dungeons.length; i++) {
            if(!checked[i] && k >= dungeons[i][0]) {
                checked[i] = true;
                dfs(L + 1, k - dungeons[i][1], dungeons);
                checked[i] = false;
            }
        }
    }
}