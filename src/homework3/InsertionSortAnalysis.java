package homework3;

public class InsertionSortAnalysis {

    public static void main(String[] args) {

        System.out.println(insertionSort(new int[]{4,3,2,1}) == 6);
        System.out.println(insertionSort(new int[]{5,4,3,2,1}) == 10);
        System.out.println(insertionSort(new int[]{2,1,3,1,2}) == 4);
        System.out.println(insertionSort(new int[]{1,1,2,2,2}) == 0);
        System.out.println(insertionSort(new int[]{12,15,1,5,6,14,11}) == 10);
    }

    /**
     * Count total number of elements already in the BIT, less than the one being inserted now.
     * With current impl use 38Mb+ memory and won't work for values of high range.
     *
     * https://www.topcoder.com/community/competitive-programming/tutorials/binary-indexed-trees
     * https://www.youtube.com/watch?v=CWDQJGaN1gY
     * https://www.youtube.com/watch?v=v_wj_mOAlig
     */
    private static long insertionSort(int[] arr) {
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
     * In binary notation num can be represented as a1b, where a represents binary digits before the last bit and b represents zeroes after the last bit.
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
