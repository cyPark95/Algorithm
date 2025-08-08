class Solution {
    public int solution(int[] money) {
        int length = money.length;

        int[] first = new int[length];
        first[0] = money[0];
        first[1] = money[0];

        int[] second = new int[length];
        second[1] = money[1];

        for (int i = 2; i < length; i++) {
            first[i] = Math.max(first[i - 1], first[i - 2] + money[i]);
            second[i] = Math.max(second[i - 1], second[i - 2] + money[i]);
        }

        return Math.max(first[length - 2], second[length - 1]);
    }
}