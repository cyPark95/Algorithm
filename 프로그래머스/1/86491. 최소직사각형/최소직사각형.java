class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);
            
            maxWidth = Math.max(maxWidth, max);
            maxHeight = Math.max(maxHeight, min);
        }

        answer = maxWidth * maxHeight;
        return answer;
    }
}