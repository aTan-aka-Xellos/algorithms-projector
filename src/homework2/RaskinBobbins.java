package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RaskinBobbins {

    private static PrintWriter out = new PrintWriter(System.out);
    private static InputReader in = new InputReader(System.in);

    public static void main(String[] args) {

        int testCases = in.nextInt();

        for (int i = 1; i <= testCases; i++) {

            int m = in.nextInt(); // money pool
            int n = in.nextInt(); // number of flavors
            int[] arr = in.readArray(n);

            int[] ans = solve(arr, m);
            out.println(++ans[0] + " " + ++ans[1]);
        }
        out.flush();
        out.close();
    }

    private static int[] solve(int[] arr, int m) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(m - arr[i])) {
                return new int[]{map.get(m - arr[i]), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
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
