package lectures;

public class Lecture {

    public static void main(String[] args) {
        System.out.println(div(100, 10));
        System.out.println(div(100, 3));
        System.out.println(div(10, 30));
        System.out.println();
        System.out.println(_div(100, 10));
        System.out.println(_div(100, 3));
        System.out.println(_div(10, 30));
    }




    // division without using /
    static double div(int a, int b) {

        double lo = 0,
                hi = Math.max(a, b),
                mid = (a + b)>>1;

        while (lo != mid && hi != mid) {
            if (mid * b >= a) hi = mid;
            else             lo = mid;
            mid = (hi + lo) / 2;
        }

        return hi;
    }

    static double _div(int a, int b) {
        double lo = 0,
                hi = Math.max(a, b),
                mid;

        for (int i = 0; i < 60; i++) {
            mid = (hi + lo) / 2;

            if (mid * b >= a)
                hi = mid;
            else
                lo = mid;

        }
        return hi;
    }

}
