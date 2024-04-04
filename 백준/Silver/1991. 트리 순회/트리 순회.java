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
    static Node head;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        head = new Node("A");
        for (int i = 0; i < N; i++) {
            String root = sr.next();
            String left = sr.next();
            String right = sr.next();

            head.insert(root, left, right);
        }
    }

    private static void solution() {
        head.printPreOrder();
        System.out.println();
        head.printInOrder();
        System.out.println();
        head.printPostOrder();
    }

    static class Node {

        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }

        public void insert(String root, String left, String right) {
            if (value.equals(root)) {
                if (!left.equals(".")) this.left = new Node(left);
                if (!right.equals(".")) this.right = new Node(right);
                return;
            }

            if (this.left != null) this.left.insert(root, left, right);
            if (this.right != null) this.right.insert(root, left, right);
        }

        public void printPreOrder() {
            System.out.print(value);
            if (left != null) left.printPreOrder();
            if (right != null) right.printPreOrder();
        }

        public void printInOrder() {
            if (left != null) left.printInOrder();
            System.out.print(value);
            if (right != null) right.printInOrder();
        }

        public void printPostOrder() {
            if (left != null) left.printPostOrder();
            if (right != null) right.printPostOrder();
            System.out.print(value);
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
    }
}
