package homework2;

import java.io.*;
import java.util.StringTokenizer;

public class LvivstarST {


    private static PrintWriter out = new PrintWriter(System.out);
    private static InputReader in = new InputReader(System.in);

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

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
            } else {
                int left  = in.nextInt();
                int right = in.nextInt();

                sb.append(blocks.count(left, right)).append("\n");
            }
        }

        out.println(sb.toString());

        out.flush();
        out.close();
    }


    private static class Blocks {

        private int numberOfBlocks;
        private int[] blocks;
        private int[] stationCount;

        Blocks(int[] stationCount) {
            this.stationCount = stationCount;

            numberOfBlocks = (int) (Math.sqrt(stationCount.length) + 1);
            blocks = new int[numberOfBlocks];

            for (int i = 0; i < stationCount.length; i++) {
                blocks[i / numberOfBlocks] += stationCount[i];
            }
        }

        private long count(int left, int right) {
            long sum = 0;
            int leftBlockIndex = left / numberOfBlocks;
            int rightBlockIndex = right / numberOfBlocks;


            if (leftBlockIndex == rightBlockIndex) {
                for (int i = left - 1; i < right; i++) {
                    sum += stationCount[i];
                }
                return sum;
            }

            // leftBlock, numberOfBlocks = number of items in the block (sqrt)
            int endOfLeftBlock = (leftBlockIndex + 1) * numberOfBlocks;
            for (int i = left - 1; i < endOfLeftBlock; i++) {
                sum += stationCount[i];
            }

            // rightBlock, numberOfBlocks = number of items in the block (sqrt)
            int startOfRightBlock = (rightBlockIndex) * numberOfBlocks;
            for (int i = startOfRightBlock; i < right; i++) {
                sum += stationCount[i];
            }

            // between
            for (int i = leftBlockIndex + 1; i < rightBlockIndex; i++) {
                sum += blocks[i];
            }

            return sum;
        }


        /**
         * @value - if ENTER: 1, if LEAVE: -1
         */
        private void updateStation(int position, int value) {
            stationCount[position - 1] += value;
            blocks[position / numberOfBlocks] += value;
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
