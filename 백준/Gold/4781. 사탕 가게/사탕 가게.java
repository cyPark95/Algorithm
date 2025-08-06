import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        ScannerReader sr = new ScannerReader();
        
        while (true) {
            int n = sr.nextInt();
            int m = (int) Math.round(sr.nextDouble() * 100);

            if (n == 0 && m == 0) {
                break;
            }

            int[] dp = new int[m + 1];
            for (int i = 0; i < n; i++) {
                int calories = sr.nextInt();
                int cost = (int) Math.round(sr.nextDouble() * 100);
                for (int j = cost; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - cost] + calories);
                }
            }

            System.out.println(dp[m]);
        }
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
