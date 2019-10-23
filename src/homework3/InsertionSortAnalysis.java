package homework3;

public class InsertionSortAnalysis {

    public static void main(String[] args) {

    /*

        12 15 1 5 6 14 11
        12 15 1   5 6 14 11
        12   15 1    5 6   14 11

        12   1 15    5 6   11 14  // 1 + 1 swap
        1 12 15      5 6 11 14    // 1 swap (1 over 12)
        1 5 6 11 12 14 15         // 2 + 2 + 2 + 1 (size of the left part when we take item from the right)

        4 3 2 1
        4 3   2 1
        3 4   1 2 // 2 swaps
        1 2 3 4   // 2 shifts from the right 2+2
     */

        System.out.println(insertionSort(new int[]{4,3,2,1}) == 6);
        System.out.println(insertionSort(new int[]{5,4,3,2,1}) == 10);
        System.out.println(insertionSort(new int[]{2,1,3,1,2}) == 4);
        System.out.println(insertionSort(new int[]{1,1,2,2,2}) == 0);
        System.out.println(insertionSort(new int[]{12,15,1,5,6,14,11}) == 10);
    }

    private static long count;

    /**
     * The idea is to count the size (n) of the left sub-array,
     * when we merge element from the right sub-array.
     * Which means we "shift" given element over n elements in the left sub-array.
     */
    static long insertionSort(int[] arr) {
        count = 0;

        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);

        System.out.println(count);
        return count;
    }

    private static void mergeSort(int[] arr, int[] aux, int left, int right) {

        if (left >= right) return;
        int mid = (right + left) >>> 1;

        mergeSort(arr, aux, left, mid);
        mergeSort(arr, aux, mid + 1, right);

        merge(arr, aux, left, mid, right);
    }

    private static void merge(int[] arr, int[] aux, int left, int mid, int right) {

        for (int k = left; k <= right; k++) {
            aux[k] = arr[k];
        }

        int i = left, j = mid + 1;
        for (int k = left; k <= right ; k++) {

                 if (i > mid)          arr[k] = aux[j++];
            else if (j > right)        arr[k] = aux[i++];
            else if (aux[i] <= aux[j]) arr[k] = aux[i++];
            else {
                                       arr[k] = aux[j++];
                                       count += mid - i + 1;
                 }
        }
    }

    /**
     * Failed some TC with TLE.
     * Count total number of elements already in the BIT, less than the one being inserted now.
     * With current impl use 38Mb+ memory and won't work for values of high range.
     *
     * https://www.topcoder.com/community/competitive-programming/tutorials/binary-indexed-trees
     * https://www.youtube.com/watch?v=CWDQJGaN1gY
     * https://www.youtube.com/watch?v=v_wj_mOAlig
     */
    private static long _insertionSort(int[] arr) {
        long count = 0;

        // this is just stupid, how to get rid of it?
        int wtf_38_dot_1469_mb_size = 10_000_000;

        BinaryIndexedTree bit = new BinaryIndexedTree(wtf_38_dot_1469_mb_size);

        for (int i = arr.length - 1; i >= 0; i--) {
            bit.update(arr[i]);
            count += bit.read(arr[i] - 1);
        }

        return count;
    }

    /**
     * In binary notation num can be represented as a1b, where a represents binary digits before the last bit
     * and b represents zeroes after the last bit.
     * Integer -num is equal to (a1b)¯ + 1 = a¯0b¯ + 1. b consists of all zeroes, so b¯ consists of all ones.
     * -num = (a1b)¯ + 1 = a¯0b¯ + 1 = a¯1b.
     * To isolate the last bit of num, need to use bitwise operator AND between num and -num:
     * a1b & a¯1b
     * (c)  https://www.topcoder.com/community/competitive-programming/tutorials/binary-indexed-trees
     */
    static class BinaryIndexedTree {

        int[] tree;
        BinaryIndexedTree(int size) {
            tree = new int[size];
        }

        void update(int index) {
            while (index < tree.length) {
                tree[index]++;
                // extracting least significant non-zero bit
                index += (index & -index);
            }
        }

        long read(int index) {
            long sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= (index & -index);
            }
            return sum;
        }
    }
    
}
