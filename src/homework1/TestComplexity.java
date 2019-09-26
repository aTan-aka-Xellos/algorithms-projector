package homework1;

public class TestComplexity {

    private static int count = 0;

    public static void main(String[] args) {

        for (int i = 100; i <= 100; i++) {
            g(i);
        }
    }

    private static void f() {
        count++;
    }


    private static void g(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j += i) {
                f();
            }
            System.out.println(i + " " + count);
        }
    }


    private static void compute(int n) {
        if (n == 0) return;
        for (int i = 0; i < n; i++)
            f();
        compute(n/2);
        compute(n/2);
    }

    private static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

}
