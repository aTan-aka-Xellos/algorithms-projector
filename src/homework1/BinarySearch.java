package homework1;

public class BinarySearch {

    private static int binarySearch(int[] a, int key) {
        int lo = 0, hi = a.length - 1, mid;

        while (lo <= hi) {
            mid = (lo + hi) >>> 1;

            if (a[mid] > key)
                hi = mid - 1;
            else if (a[mid] < key)
                lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(binarySearch(new int[]{}, 0) == -1);
        System.out.println(binarySearch(new int[]{0}, 0)== 0);
        System.out.println(binarySearch(new int[]{0}, 1)== -1);

        System.out.println(binarySearch(new int[]{0, 1}, 0) == 0);
        System.out.println(binarySearch(new int[]{0, 1}, 1) == 1);
        System.out.println(binarySearch(new int[]{0, 1}, 2)== -1);

        System.out.println(binarySearch(new int[]{0, 1, 2}, 0) == 0);
        System.out.println(binarySearch(new int[]{0, 1, 2}, 1) == 1);
        System.out.println(binarySearch(new int[]{0, 1, 2}, 2) == 2);
        System.out.println(binarySearch(new int[]{0, 1, 2}, 3)== -1);

        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 0) == 0);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 1) == 1);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 2) == 2);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 3) == 3);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 4)== -1);

        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 0) == 0);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 1) == 1);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 2) == 2);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 3) == 3);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 4) == 4);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 5)== -1);

        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 0) == 0);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 1) == 1);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 2) == 2);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 3) == 3);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 4) == 4);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 5) == 5);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 6) == -1);
    }



}
