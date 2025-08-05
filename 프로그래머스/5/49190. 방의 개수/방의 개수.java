import java.util.*;

class Solution {

    private static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
    private static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public int solution(int[] arrows) {
        int answer = 0;

        Map<Point, Set<Point>> map = new HashMap<>();

        Point current = new Point(0, 0);
        map.put(current, new HashSet<>());

        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                int ny = current.y + dy[arrow];
                int nx = current.x + dx[arrow];
                Point next = new Point(ny, nx);

                if (!map.containsKey(next)) {
                    map.put(next, new HashSet<>());
                } else if(!map.get(current).contains(next)) {
                    answer++;
                }

                map.get(current).add(next);
                map.get(next).add(current);

                current = next;
            }
        }

        return answer;
    }

    static class Point {

        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return y == ((Point) o).y && x == ((Point) o).x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}