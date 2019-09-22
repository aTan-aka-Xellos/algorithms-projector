package homework1;

public class TestComplexity {

    private static int count = 0;

    public static void main(String[] args) {

        for (int i = 20; i <= 20; i++) {
            g(i);
        }
    }

    private static void f() {
        count++;
    }


    private static void g(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j += i) {
                count++;
                f();
            }
            System.out.println(count);
            count = 0;
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
