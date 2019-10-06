package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AutoLoan {

    private static PrintWriter out = new PrintWriter(System.out);
    private static InputReader in = new InputReader(System.in);

    public static void main(String[] args) {

        double price = in.nextDouble();
        double monthly = in.nextDouble();
        int loanTerm = in.nextInt();

        double lo = 0, hi = 100;
        // calculation with low error rate (see lecture with Cube)
        // 2^32 = 4,294,967,296
        // 100 / 2^ 32 = 2.32e-8 (e-6 is enough)
        for (int i = 0; i < 32; i++) {

            // store init balance
            double balance = price;
            double mid = (hi + lo) / 2;
            for (int j = 0; j < loanTerm; j++) {
                /*
                Next balance: current balance (B) * year interest in % (P) - monthly payment (M)
                B = B * P - M
                Convert % into number: P/100 => Interest = (1 + P/100)
                For month we need 1/12 of year interest
                 */
                balance = balance * (1 + mid / (100 * 12)) - monthly;
            }
            if (balance > 0)
                hi = mid;
            else
                lo = mid;
        }

        out.println(lo);
        out.flush();
        out.close();
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

        long nextLong() {
            return Long.parseLong(next());
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
