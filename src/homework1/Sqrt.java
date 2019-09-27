package homework1;

import static utils.TestUtils.assertEquals;

public class Sqrt {

    private static int sqrt(int value) {
        double lo = 0, hi = value, mid = (hi + lo) / 2;

        while (lo != mid && hi != mid) {
            if (mid * mid < value)
                lo = mid;
            else
                hi = mid;
            mid = (hi + lo) / 2;
        }
        return (int) hi;
    }


    public static void main(String[] args) {

        assertEquals(sqrt(1), 1);
        assertEquals(sqrt(2), 1);
        assertEquals(sqrt(3), 1);

        assertEquals(sqrt(4), 2);
        assertEquals(sqrt(5), 2);
        assertEquals(sqrt(8), 2);

        assertEquals(sqrt(9), 3);
        assertEquals(sqrt(10), 3);

        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
            assertEquals(sqrt(i), (int) Math.sqrt(i));
        }
    }
}
