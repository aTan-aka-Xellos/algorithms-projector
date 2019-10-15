package homework3;

public class InsertionSortAnalysis {

    public static void main(String[] args) {

        int result;

//        result = insertionSort(new int[]{4,3,2,1}); // 6
//        System.out.println(result);

        result = insertionSort(new int[]{2, 1, 3, 1, 2}); // 4
        System.out.println(result);

//        result = insertionSort(new int[]{1, 1, 2, 2, 2}); // 0
//        System.out.println(result);

    }

    private static int[] heap;
    private static int heapSize;

    static int insertionSort(int[] arr) {
        heapSize = 0;
        heap = new int[arr.length + 1];
        int count = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            count += insert(arr[i]);
        }
        return count;
    }

    // return size of sub-tree (heap.length - final_position)
    private static int insert(int i) {
        int count = 0;

        heapSize++;
        int index = heapSize;
        heap[heapSize] = i;


        while (index > 1 && heap[index] > heap[index / 2]) {
            swap(index, index / 2);
            index = index >> 1;
            count++;
        }


        return count;
    }



    private static void swap(int i, int j) {
        int temp = heap[j];
        heap[j] = heap[i];
        heap[i] = temp;
    }

}
