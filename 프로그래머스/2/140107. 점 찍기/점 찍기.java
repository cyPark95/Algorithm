class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long pow = (long) Math.pow(d, 2);

        for (long x = 0; x <= d; x += k) {
            long y = (long) Math.sqrt(pow - (long) Math.pow(x, 2));
            answer += (y / k) + 1;
        }
        return answer;
    }
}