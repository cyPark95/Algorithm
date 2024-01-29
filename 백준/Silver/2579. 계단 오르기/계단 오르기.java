import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] stairs;
    static Integer[] dp;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = sr.nextInt();
        }

        dp = new Integer[N + 1];
    }

    private static void solution() {
        dp[0] = stairs[0];
        dp[1] = stairs[1];

        if(N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        System.out.println(recursive(N));
    }

    private static int recursive(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(recursive(N - 2), recursive(N - 3) + stairs[N - 1]) + stairs[N];
        }

        return dp[N];
    }

    static class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(readLine());
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
