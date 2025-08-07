import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static int[] nums;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = sr.nextInt();
        }
    }

    private static void solution() {
        int[][] dp = new int[N + 1][N + 1];
        for (int length = 1; length < N; length++) {
            for (int start = 1; start <= N - length; start++) {
                int end = start + length;

                if (nums[start] == nums[end]) {
                    dp[start][end] = dp[start + 1][end - 1];
                } else {
                    dp[start][end] = Math.min(dp[start][end - 1], dp[start + 1][end]) + 1;
                }
            }
        }

        System.out.println(dp[1][N]);
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
