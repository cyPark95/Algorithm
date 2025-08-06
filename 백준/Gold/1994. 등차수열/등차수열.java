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

    static int n;
    static int[] arr;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        n = sr.nextInt();

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sr.nextInt();
        }
    }

    private static void solution() {
        int answer = 1;
        int[][] dp = new int[n + 1][n + 1];

        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = 2;

                int previous = arr[i] - (arr[j] - arr[i]);
                int l;
                for (l = i - 1; l >= 1; l--) {
                    if (arr[l] == previous) {
                        break;
                    }
                }

                dp[i][j] = Math.max(dp[i][j], dp[l][i] + 1);
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
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
