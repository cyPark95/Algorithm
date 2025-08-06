import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int D;
    static int P;
    static int[][] pipes;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        D = sr.nextInt();
        P = sr.nextInt();

        pipes = new int[P][2];
        for (int i = 0; i < P; i++) {
            pipes[i][0] = sr.nextInt();
            pipes[i][1] = sr.nextInt();
        }
    }

    private static void solution() {
        int[] dp = new int[D + 1];
        for (int i = 0; i < P; i++) {
            int L = pipes[i][0];
            int C = pipes[i][1];

            for (int j = D; j > L; j--) {
                if (dp[j - L] == 0) {
                    continue;
                }

                dp[j] = Math.max(dp[j], Math.min(dp[j - L], C));
            }

            dp[L] = Math.max(dp[L], C);
        }

        System.out.println(dp[D]);
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
