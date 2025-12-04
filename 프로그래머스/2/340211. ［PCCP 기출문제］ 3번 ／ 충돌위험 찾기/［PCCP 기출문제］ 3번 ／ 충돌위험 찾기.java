import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<Position, Integer> visited = new HashMap<>();

        for (int[] route : routes) {
            int time = 0;
            int[] current = points[route[0] - 1];
            Position position = new Position(time, current[0], current[1]);
            visited.put(position, visited.getOrDefault(position, 0) + 1);

            for (int point : route) {
                int[] target = points[point - 1];

                while(current[0] != target[0] || current[1] != target[1]){
                    time++;
                    current = move(target, current);
                    position = new Position(time, current[0], current[1]);
                    visited.put(position, visited.getOrDefault(position, 0) + 1);
                }
            }
        }

        for (int count : visited.values()) {
            if (count >= 2) {
                answer++;
            }
        }

        return answer;
    }

    private int[] move(int[] target, int[] current) {
        int y = current[0];
        int x = current[1];

        if (target[0] < y) {
            y--;
        } else if (target[0] > y) {
            y++;
        } else if (target[1] < x) {
            x--;
        } else if (target[1] > x) {
            x++;
        }

        return new int[]{ y, x };
    }

    static class Position {
        int time;
        int y;
        int x;

        public Position(int time, int y, int x) {
            this.time = time;
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Position)) {
                return false;
            }

            Position position = (Position) o;
            return this.time == position.time && this.y == position.y && this.x == position.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(time, y, x);
        }
    }
}