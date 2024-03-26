import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static int[] A;

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        A = new int[N + 2];
        for (int i = 0; i < N; i++) {
            A[i] = sr.nextInt();
        }
    }

    static void solution() {
        int answer = 0;
        int index = 0;
        while (index < N) {
            if (A[index] > 0) {
                answer += (A[index] * 3);

                int tmp = Math.min(A[index], A[index + 1]);
                answer += (2 * tmp);
                A[index + 1] -= tmp;

                tmp = Math.min(tmp, A[index + 2] - Math.min(A[index + 1], A[index + 2]));
                answer += (2 * tmp);
                A[index + 2] -= tmp;
            }

            index++;
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
