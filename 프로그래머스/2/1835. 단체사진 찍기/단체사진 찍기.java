class Solution {
    
    static int answer;
    static char[] friends;
    static boolean[] visited;

    public int solution(int n, String[] data) {
        answer = 0;
        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited = new boolean[friends.length];

        dfs(data, "");
        return answer;
    }

    private void dfs(String[] data, String order) {
        if (friends.length == order.length()) {
            if (checked(data, order)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(data, order + friends[i]);
            visited[i] = false;
        }
    }

    private boolean checked(String[] data, String order) {
        for (String condition : data) {
            int distance = Math.abs(order.indexOf(condition.charAt(0)) - order.indexOf(condition.charAt(2))) - 1;
            char op = condition.charAt(3);
            int interval = condition.charAt(4) - '0';

            switch (op) {
                case '<':
                    if (distance >= interval) {
                        return false;
                    }
                    break;
                case '>':
                    if (distance <= interval) {
                        return false;
                    }
                    break;
                default:
                    if (distance != interval) {
                        return false;
                    }
            }
        }

        return true;
    }
}