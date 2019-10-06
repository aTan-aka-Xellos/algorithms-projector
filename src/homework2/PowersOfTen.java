package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PowersOfTen {

    private static PrintWriter out = new PrintWriter(System.out);
    private static InputReader in = new InputReader(System.in);

    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();

        int[] indices = generateIndices();
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            int val = Arrays.binarySearch(indices, k) > -1 ? 1 : 0;
//            int val = binarySearch(indices, k) > -1 ? 1 : 0;
            result.append(val).append(" ");
        }

        out.println(result);

        out.flush();
        out.close();
    }

    private static int[] generateIndices() {
        int i = 0;
        int[] indices = new int[65536];

        indices [0] = 1;
        while (i++ < 65535) {
            indices[i] = indices [i - 1] + i;
        }
        return indices;
    }

    private static int binarySearch(int[] a, int key) {
        int lo = 0, hi = a.length - 1, mid;

        while (lo <= hi) {
            mid = (lo + hi) >>> 1;

            if (a[mid] > key)
                hi = mid - 1;
            else if (a[mid] < key)
                lo = mid + 1;
            else return mid;
        }
        return -1;
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
