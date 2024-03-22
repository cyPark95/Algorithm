import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, M;
    static int[] card, target;

    private static void input() {
        ScannerReader sr = new ScannerReader();

        N = sr.nextInt();
        card = new int[N];
        for(int i=0; i<N; i++) {
            card[i] = sr.nextInt();
        }

        M = sr.nextInt();
        target = new int[M];
        for (int i = 0; i < M; i++) {
            target[i] = sr.nextInt();
        }
    }

    private static void solution() {
        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int i : card) {
            cardCount.put(i, cardCount.getOrDefault(i, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : target) {
            sb.append(cardCount.getOrDefault(i, 0)).append(" ");
        }

        System.out.println(sb);
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
