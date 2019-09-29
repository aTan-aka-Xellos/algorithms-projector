package homework1;

public class Lecture {

    public static void main(String[] args) {
        System.out.println(_div (100, 3));

    }


    static double _div(int a, int b) {
        double lo = 0, hi = Math.max(a, b), mid = (a + b)>>1;

        while (lo != mid && hi != mid) {

            if (mid * b >= a) {
                hi = mid;
            } else {
                lo = mid;
            }
            mid = (hi + lo) / 2;
        }

        return hi;

    }


}
