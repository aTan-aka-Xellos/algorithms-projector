package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/projector-algo-base-9-hw-2-zpun0n6c/challenges/garland
 */
public class Garland {

    // TODO: unfinished - 58/60 TC passed

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

        double lo = 0, hi = a, guess;
        double prev_lo = lo, prev_hi = hi;

        double B = Integer.MAX_VALUE;
        double next = Integer.MIN_VALUE;
        double previous_next = Integer.MAX_VALUE;

        boolean directionRight = true;

        int count = 0;
        while (count < 60) {
            count++;

            guess = (lo + hi) / 2;

            double prev = a;
            double mid = guess;

            for (int i = 0; i < n - 2; i++) {
                next = Math.abs(2 * (mid + 1) - prev);
                prev = mid;
                mid = next;
            }

            if (previous_next < next) {
                if (directionRight) {
                    lo = prev_lo;
                } else {
                    hi = prev_hi;
                }
                directionRight = !directionRight;
            }

            if (directionRight) {
                prev_lo = lo;
                lo = guess;
            } else {
                prev_hi = hi;
                hi = guess;
            }

            B = Math.min(B, next);

            previous_next = next;
        }
        return B;
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
