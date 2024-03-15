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

    static int N, government, sum;
    static int[] budgets;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        budgets = new int[N];
        for (int i = 0; i < N; i++) {
            sum += budgets[i] = sr.nextInt();
        }
        government = sr.nextInt();
    }

    private static void solution() {
        Arrays.sort(budgets);

        if (sum <= government) {
            System.out.println(budgets[budgets.length - 1]);
            return;
        }

        int count = 0;
        for (int budget : budgets) {
            double average = (double) government / (N - count);
            if (budget > average) {
                break;
            }

            count++;
            government -= budget;
        }

        System.out.println(government / (N - count));
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
