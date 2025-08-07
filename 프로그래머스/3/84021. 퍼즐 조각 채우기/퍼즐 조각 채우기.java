import java.util.*;

class Solution {

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        List<List<Point>> emptySpaces = new ArrayList<>();
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[i].length; j++) {
                if (game_board[i][j] == 0) {
                    List<Point> emptySpace = getSpace(game_board, i, j, 0);
                    emptySpaces.add(emptySpace);
                }
            }
        }

        List<List<Point>> tableSpaces = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 1) {
                    List<Point> tableSpace = getSpace(table, i, j, 1);
                    tableSpaces.add(tableSpace);
                }
            }
        }

        boolean[] used = new boolean[tableSpaces.size()];

        for (List<Point> emptySpace : emptySpaces) {
            Collections.sort(emptySpace);

            for (int j = 0; j < tableSpaces.size(); j++) {
                if (used[j]) {
                    continue;
                }

                List<Point> tableSpace = tableSpaces.get(j);

                if (match(emptySpace, tableSpace)) {
                    used[j] = true;
                    answer += tableSpace.size();
                    break;
                }
            }
        }

        return answer;
    }

    private List<Point> getSpace(int[][] board, int y, int x, int flag) {
        Point current = new Point(y, x);

        List<Point> space = new ArrayList<>();
        space.add(current);

        Queue<Point> q = new LinkedList<>();
        q.offer(current);
        board[current.y][current.x] = 1 - flag;

        while (!q.isEmpty()) {
            current = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (ny >= 0 && ny < board.length && nx >= 0 && nx < board[0].length) {
                    if (board[ny][nx] != flag) {
                        continue;
                    }

                    board[ny][nx] = 1 - flag;
                    space.add(new Point(ny, nx));
                    q.offer(new Point(ny, nx));
                }
            }
        }

        normalize(space);
        return space;
    }

    private boolean match(List<Point> emptySpace, List<Point> tableSpace) {
        if (emptySpace.size() != tableSpace.size()) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            rotate(tableSpace);
            normalize(tableSpace);
            if (compare(emptySpace, tableSpace)) {
                return true;
            }
        }

        return false;
    }

    private void rotate(List<Point> tableSpace) {
        for (Point point : tableSpace) {
            int y = point.y;
            int x = point.x;
            point.y = (-1) * x;
            point.x = y;
        }
    }

    private boolean compare(List<Point> emptySpace, List<Point> tableSpace) {
        for (int i = 0; i < emptySpace.size(); i++) {
            if (emptySpace.get(i).y != tableSpace.get(i).y || emptySpace.get(i).x != tableSpace.get(i).x) {
                return false;
            }
        }

        return true;
    }

    private void normalize(List<Point> space) {
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;

        for (Point point : space) {
            minY = Math.min(minY, point.y);
            minX = Math.min(minX, point.x);
        }

        for (Point point : space) {
            point.y -= minY;
            point.x -= minX;
        }

        Collections.sort(space);
    }

    static class Point implements Comparable<Point> {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Point o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }

            return this.y - o.y;
        }
    }
}