package homework2;

import static java.lang.String.format;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LvivstarST {

    private static ByteArrayOutputStream interceptedStream = new ByteArrayOutputStream();
    private static PrintStream systemOut = System.out;

    private static PrintWriter out = new PrintWriter(System.out);
    private static InputReader in = new InputReader(System.in);

    public static void main(String[] args) throws IOException {

        String testFile = "resources/homework2/TC_%s.txt";
        String testAns = "resources/homework2/TC_%sa.txt";

        int tcCount = 0;
        for (int testCase = 0; testCase < tcCount; testCase++) {

            enableTestFromFile(format(testFile, testCase));
            solve();

            long[] ans = getResultsFromInterceptedStream();
            Assert.assertEquals(ans, $.readFileAsLong(format(testAns, testCase)), testCase);

            out.flush();
        }

        if (tcCount == 0) {
            solve();
        }
    }

    private static void solve() {

        int numberOfStations = in.nextInt();
        int[] stationCounts = in.readArray(numberOfStations);
        int queryNumber = in.nextInt();

        Blocks blocks = new Blocks(stationCounts);

        for (int i = 0; i < queryNumber; i++) {
            String query = in.next();

            if (query.charAt(0) == 'E') {
                blocks.updateStation(in.nextInt(), 1);
            } else if (query.charAt(0) == 'L') {
                blocks.updateStation(in.nextInt(), -1);
            } else if (query.charAt(0) == 'C') {
                int left  = in.nextInt();
                int right = in.nextInt();

                String result = String.valueOf(blocks.count(left, right));
                out.println(result);
            }
        }

        out.flush();
        out.close();
    }


    private static class Blocks {

        private int numberOfBlocks;
        private long[] blocks;
        private int[] stationCount;

        Blocks(int[] stationCount) {
            this.stationCount = stationCount;

            numberOfBlocks = (int) (Math.sqrt(stationCount.length) + 1);
            blocks = new long[numberOfBlocks];

            for (int i = 0; i < stationCount.length; i++) {
                blocks[i / numberOfBlocks] += stationCount[i];
            }
        }

        private long count(int left, int right) {
            long sum = 0;
            int leftBlockIndex = --left / numberOfBlocks;
            int rightBlockIndex = --right / numberOfBlocks;


            if (leftBlockIndex == rightBlockIndex) {
                for (int i = left; i <= right; i++) {
                    sum += stationCount[i];
                }
                return sum;
            }

            // leftBlock, numberOfBlocks = number of items in the block (sqrt)
            int endOfLeftBlock = (leftBlockIndex + 1) * numberOfBlocks - 1;
            for (int i = left; i <= endOfLeftBlock; i++) {
                sum += stationCount[i];
            }

            // rightBlock, numberOfBlocks = number of items in the block (sqrt)
            int startOfRightBlock = (rightBlockIndex) * numberOfBlocks;
            for (int i = startOfRightBlock; i <= right; i++) {
                sum += stationCount[i];
            }

            // between
            for (int i = leftBlockIndex + 1; i < rightBlockIndex; i++) { // check <=
                sum += blocks[i];
            }
            return sum;
        }


        /**
         * @value - if ENTER: 1, if LEAVE: -1
         */
        private void updateStation(int position, int value) {
            position--;
            stationCount[position] += value;
            blocks[position / numberOfBlocks] += value;
        }
    }

    private static void enableTestFromFile(String fileName) throws IOException {
        System.setOut(new PrintStream(interceptedStream));
        out = new PrintWriter(System.out);
        in = new InputReader(new File(fileName));
    }

    private static long[] getResultsFromInterceptedStream() {
        out.flush();
        String[] stringArray = interceptedStream.toString().split("\r\n");

        interceptedStream.reset();
        System.setOut(systemOut);
        out = new PrintWriter(System.out);

        return $.arrayStringToLong(stringArray);
    }

    private static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        /**
         * Read from the file.
         */
        InputReader(File file) throws FileNotFoundException {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 32768);
            tokenizer = null;
        }

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

        long[] readArrayLong(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {

                array[i] = nextLong();
            }
            return array;
        }
    }

    /**
     * Util class with different util methods.
     */
    private static class $ {

        static int[] ints(int... args) {
            return args;
        }

        static long[] longs(long... args) {
            return args;
        }

        static String[] strings(String... args) {
            return args;
        }

        static long[] arrayStringToLong(String[] stringArray) {
            long[] longArray = new long[stringArray.length];

            for (int i = 0; i < stringArray.length; i++) {
                longArray[i] = Long.parseLong(stringArray[i]);
            }
            return longArray;
        }

        static int[] arrayStringToInt(String[] stringArray) {
            int[] intArray = new int[stringArray.length];

            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            return intArray;
        }

        static long GCD(long a, long b) {
            return b == 0 ? a : GCD(b, a % b);
        }

        static boolean isPrime(long n) {
            if (n == 1) return false;

            long limit = (long) Math.sqrt(n);
            for (long i = 2; i <= limit; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }

        static String[] readFile(String fileName) {
            List<String> list = new ArrayList<>();

            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                list = stream.collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list.toArray(new String[0]);
        }

        static long[] readFileAsLong(String fileName) {
            return arrayStringToLong(readFile(fileName));
        }

        static int[] readFileAsInt(String fileName) {
            return arrayStringToInt(readFile(fileName));
        }
    }

    /**
     * Assert method for testing.
     */
    private static class Assert {

        static void assertEquals(int actual, int expected) {
            if (actual != expected) {
                throw new RuntimeException("\n" + actual + " != "  + expected);
            }
        }

        static void assertEquals(long actual, long expected) {
            if (actual != expected) {
                throw new RuntimeException("\n" + actual + " != "  + expected);
            }
        }

        static void assertEquals(int[] actual, int[] expected) {
            if (!Arrays.equals(actual, expected)) {
                throw new RuntimeException("\n" + Arrays.toString(actual)
                    + "\n" + Arrays.toString(expected));
            }
        }

        static void assertEquals(long[] actual, long[] expected, int index) {
            if (!Arrays.equals(actual, expected)) {
                throw new RuntimeException("\n" + Arrays.toString(actual)
                    + "\n" + Arrays.toString(expected));
            }
            System.out.println("Test passed " + index);
        }
    }
}
