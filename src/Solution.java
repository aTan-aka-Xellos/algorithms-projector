import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static PrintWriter out = new PrintWriter(System.out);
    private static InputReader in = new InputReader(System.in);

    public static void main(String[] args) {

        int testCases = in.nextInt();

        for (int i = 1; i <= testCases; i++) {

            int n = in.nextInt(); // array size
            int k = in.nextInt(); // number of wall differences

            int[] arr = in.readArray(n);

            String s = "Case #%s: %d";
            int ans = solve(arr, k);
            s = String.format(s, i, ans);

            out.print(s);
            if (i < testCases)
                out.println();
        }
        out.flush();
        out.close();

    }

    private static int solve(int[] arr, int k) {

        List<Node> list = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            int count = 1;

            while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                i++;
                count++;
            }
            Node node = new Node(arr[i], count);
            list.add(node);
        }

        int count = 0;
        if (list.size() <= k) return count;

        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i - 1).val == list.get(i + 1).val) {

                count += list.get(i).weight;

                list.get(i - 1).weight += list.get(i).weight + list.get(i + 1).weight;
                list.remove(i + 1);
                list.remove(i);
            }
        }


        if (list.size() <= k) return count;
        return count + list.size() - k - 1;
    }


    static class Node {
        Node(int val, int weight) {this.val = val; this.weight = weight;}
        int val;
        int weight;
        public String toString() {return val + " " + weight;}
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        boolean hasNext() {
            try {
                return reader.ready();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        String next() {

            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }
    }
}
