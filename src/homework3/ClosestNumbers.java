package homework3;

import java.io.*;
import java.util.*;

public class ClosestNumbers {

        // Complete the closestNumbers function below.
        // most stupid and straightforward solution
        // complexity: 3N + 2 NlogN + N (map, could be up to n in the worst case)

        static int[] closestNumbers(int[] arr) {

            int n = arr.length;
            int[] diff = new int[n - 1];
            Arrays.sort(arr); // O(nlogn)

            // O(n)
            for (int i = 1; i < n; i++) {
                diff[i - 1] = arr[i] - arr[i - 1];
            }
            int[] diff_copy = Arrays.copyOf(diff, n - 1); // O(n)

            Arrays.sort(diff); // O(nlogn)

            List<Integer> list = new ArrayList<>();
            // O(n)
            for (int i = 0; i < n - 1; i++) {
                if (diff_copy[i] == diff[0]) {
                    list.add(arr[i]);
                    list.add(arr[i + 1]);
                }
            }

            return list.stream().mapToInt(i->i).toArray(); // O(1) - O(n)
        }

        private static final Scanner scanner = new Scanner(System.in);

        // this task has non-standard output, commented out to print to console
        public static void main(String[] args) throws IOException {
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = closestNumbers(arr);

            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
//                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    System.out.print(" ");
//                    bufferedWriter.write(" ");
                }
            }

//            bufferedWriter.newLine();
//            bufferedWriter.close();

            scanner.close();
        }
}
