package homework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.facebook.com/hackercup/problem/1611251319125133/
 */
public class Laundro {




    private static PrintWriter out = new PrintWriter(System.out);
    private static InputReader in = new InputReader(System.in);

    public static void main(String[] args) {

        int T = in.nextInt(); // number of TC

        for (int i = 1; i <= T; i++) {
            solve();
        }

        out.flush();
        out.close();
    }

    private static void solve() {

        long totalDuration = 0;

        int numberOfLoads = in.nextInt();
        int numberOfMachines = in.nextInt();
        int numberOfDryers = in.nextInt();
        int dryDuration = in.nextInt();
        int[] washDuration = in.readArray(numberOfMachines);

        Arrays.sort(washDuration);

        for (int i = 0; i < numberOfLoads; i++) {

a
        }



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
