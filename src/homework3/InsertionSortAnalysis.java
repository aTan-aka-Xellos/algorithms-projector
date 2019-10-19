package homework3;

public class InsertionSortAnalysis {

    public static void main(String[] args) {

//        System.out.println(insertionSort(new int[]{4,3,2,1}) == 6);
//        System.out.println(insertionSort(new int[]{5,4,3,2,1}) == 10);
//        System.out.println(insertionSort(new int[]{2,1,3,1,2}) == 4);
//        System.out.println(insertionSort(new int[]{1,1,2,2,2}) == 0);

        System.out.println(insertionSort(new int[]{12,15,1,5,6,14,11}) == 10);
    }

    private static int[] heap;
    private static int heapSize;

    private static int insertionSort(int[] arr) {
        heapSize = 0;
        heap = new int[arr.length + 1];
        int count = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            count += insert(arr[i]);
        }
        return count;
    }

    // return size of sub-tree
    private static int insert(int i) {
        heapSize++;
        heap[heapSize] = i;
        int index = heapSize;

        while (index > 1 && heap[index] > heap[index / 2]) {
            swap(index, index / 2);
            index >>= 1;
        }
        return countNodes(index) - 1;
    }

    private static int countNodes(int position) {
        int sum = 0;
        if (position > heapSize) return 0;

        sum += countNodes(2 * position);
        sum += countNodes(2 * position + 1);

        return sum + 1;
    }

    private static void swap(int i, int j) {
        int temp = heap[j];
        heap[j] = heap[i];
        heap[i] = temp;
    }

//        heap = new int[]{-1, 10,9,8,7,6,5,4,3,2,1};
//        heapSize = 10;
//
//        System.out.println(countNodes(1) - 1); // 9
//        System.out.println(countNodes(2) - 1); // 5
//        System.out.println(countNodes(3) - 1); // 2
//        System.out.println(countNodes(4) - 1); // 2
//        System.out.println(countNodes(5) - 1); // 1
//        System.out.println(countNodes(6) - 1); // 0
//        System.out.println(countNodes(7) - 1); // 0
//        System.out.println(countNodes(8) - 1); // 0
//        System.out.println(countNodes(9) - 1); // 0
//        System.out.println(countNodes(10) - 1); // 0

}
