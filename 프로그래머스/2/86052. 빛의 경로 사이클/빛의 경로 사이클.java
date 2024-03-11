import java.util.*;

class Solution {

    static int height, width;
    static boolean[][][] visited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        height = grid.length;
        width = grid[0].length();

        visited = new boolean[height][width][4];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 4; k++) {
                    if (visited[i][j][k]) {
                        continue;
                    }

                    answer.add(light(grid, new int[]{i, j}, k));
                }
            }
        }

        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int light(String[] grid, int[] cell, int dir) {
        int count = 0;
        while (!visited[cell[0]][cell[1]][dir]) {
            count++;
            visited[cell[0]][cell[1]][dir] = true;
            dir = change(grid[cell[0]].charAt(cell[1]), dir);
            cell = move(cell, dir);
        }

        return count;
    }

    private int change(char cell, int dir) {
        if (cell == 'L') {
            return (dir + 3) % 4;
        }

        if (cell == 'R') {
            return (dir + 1) % 4;
        }

        return dir;
    }

    private int[] move(int[] cur, int dir) {
        int nr = (cur[0] + dy[dir] + height) % height;
        int nx = (cur[1] + dx[dir] + width) % width;
        return new int[]{nr, nx};
    }
}