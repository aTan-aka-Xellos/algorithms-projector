package homework1;

public class BinarySearch {

    private static int binarySearch(int[] a, int key) {
        if (a.length == 0) return -1;

        int lo = 0, hi = a.length, mid;

        while (hi - lo > 1) {
            mid = (lo + hi) >>> 1;

            if (a[mid] <= key)
                lo = mid;
            else {
                hi = mid;
            }
        }

        if (a[lo] == key) return lo;
        return -1;
    }

    public static void main(String[] args) {

        int a = Integer.MAX_VALUE - 100;
        int b = ((Integer.MAX_VALUE - 100) + (Integer.MAX_VALUE - 100)) >>> 1;
        System.out.println(a == b);

        System.out.println(binarySearch(new int[]{}, 0)  == -1);
        System.out.println(binarySearch(new int[]{0}, 0) == 0);
        System.out.println(binarySearch(new int[]{0}, 1) == -1);

        System.out.println(binarySearch(new int[]{0, 1}, 0) == 0);
        System.out.println(binarySearch(new int[]{0, 1}, 1) == 1);
        System.out.println(binarySearch(new int[]{0, 1}, 2) == -1);

        System.out.println(binarySearch(new int[]{0, 1, 2}, 0) == 0);
        System.out.println(binarySearch(new int[]{0, 1, 2}, 1) == 1);
        System.out.println(binarySearch(new int[]{0, 1, 2}, 2) == 2);
        System.out.println(binarySearch(new int[]{0, 1, 2}, 3) == -1);

        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 0) == 0);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 1) == 1);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 2) == 2);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 3) == 3);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3}, 4) == -1);

        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 0) == 0);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 1) == 1);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 2) == 2);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 3) == 3);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 4) == 4);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4}, 5) == -1);

        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 0) == 0);
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 1) == 1);
        System.out.println(binarySearch(new int[]{0, 1, 3, 5, 8, 9}, 3) == 2);
        System.out.println(binarySearch(new int[]{0, 1, 3, 5, 8, 9}, 5) == 3);
        System.out.println(binarySearch(new int[]{0, 1, 3, 5, 8, 9}, 8) == 4);
        System.out.println(binarySearch(new int[]{0, 1, 3, 5, 8, 9}, 9) == 5);
        System.out.println(binarySearch(new int[]{0, 1, 3, 5, 8, 9}, 2) == -1);
        System.out.println(binarySearch(new int[]{0, 1, 3, 5, 8, 9}, 7) == -1);
    }



}
