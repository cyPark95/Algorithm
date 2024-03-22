class Solution {

    static int answer;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int sum, int L) {
        if (L == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, sum + numbers[L], L + 1);
        dfs(numbers, target, sum - numbers[L], L + 1);
    }
}