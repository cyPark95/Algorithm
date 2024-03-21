class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            boolean flag = true;

            int prev = 0;
            for (char c : skill.toCharArray()) {
                int idx = tree.indexOf(c);
                if (idx == -1) {
                    idx = Integer.MAX_VALUE;
                }

                if (prev > idx) {
                    flag = false;
                    break;
                }

                prev = idx;
            }

            if (flag) {
                answer++;
            }
        }

        return answer;
    }
}