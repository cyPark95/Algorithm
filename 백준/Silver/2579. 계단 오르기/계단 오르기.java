import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int n;
    static int[] stairs;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        n = sr.nextInt();

        stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = sr.nextInt();
        }
    }

    private static void solution() {
        int[] dp = new int[n + 1];
        dp[1] = stairs[1];

        if (n > 1) {
            dp[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(dp[n]);
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
