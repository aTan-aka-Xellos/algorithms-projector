package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


// TODO: unfinished
public class Lvivstar {


    private static PrintWriter out = new PrintWriter(System.out);
    private static InputReader in = new InputReader(System.in);

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int numberOfStations = in.nextInt();
        int[] counts = in.readArray(numberOfStations);

        int queryNumber = in.nextInt();

        for (int i = 0; i < queryNumber; i++) {
            String query = in.next();

            if (query.charAt(0) == 'E') {
                counts[in.nextInt() - 1]++;
            } else if (query.charAt(0) == 'L') {
                counts[in.nextInt() - 1]--;
            } else {

                int start = in.nextInt();
                int end = in.nextInt();

                long count = 0;
                for (int j = start - 1; j < end; j++) {
                    count += counts[j];
                }
                sb.append(count);
                sb.append("\n");
            }
        }

        out.println(sb.toString());

        out.flush();
        out.close();
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
