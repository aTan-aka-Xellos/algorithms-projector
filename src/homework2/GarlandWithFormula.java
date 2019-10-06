package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GarlandWithFormula {

    private static PrintWriter out = new PrintWriter(System.out);
    private static InputReader in = new InputReader(System.in);

    public static void main(String[] args) {

        int n = in.nextInt();
        double a = in.nextDouble();

        out.println(String.format("%.4f", solve(n, a)));
        out.flush();
        out.close();
    }

    private static double solve(int n, double a) {

        n -= 2;
        double lo = 0, hi = Integer.MAX_VALUE;

        while (hi - lo > 0.0001) {
            double prev = a;
            double mid = (lo + hi) / 2;
            // stupid formula of parabola
            double minP = (mid - n * (n - a + 1)) / (n + 1);

            double current = minP;

            for (int i = 1; i < n; i++) {
                double next = 2.0 * (current + 1.0) - prev;
                if (next < minP) {
                    minP = next;
                }
                prev = current;
                current = next;
                if (minP < 0)
                    break;
            }

            if (minP < 0) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static class InputReader {
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

        double nextDouble() {
            return Double.parseDouble(next());
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
