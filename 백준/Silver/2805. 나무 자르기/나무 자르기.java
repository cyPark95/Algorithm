import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, M, max;
    static int[] trees;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        M = sr.nextInt();

        trees = new int[N];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            trees[i] = sr.nextInt();
            max = Math.max(max, trees[i]);
        }
    }

    private static void solution() {
        int answer = binarySearch();
        System.out.println(answer);
    }

    private static int binarySearch() {
        int left = 0;
        int right = max;

        while (left <= right) {
            int mid = (left + right) / 2;
            long total = cut(mid);

            if (total < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    private static long cut(int H) {
        return Arrays.stream(trees)
                .filter(n -> n > H)
                .mapToLong(n -> n - H)
                .sum();
    }

    static class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String getReadLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return "";
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(getReadLine());
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
