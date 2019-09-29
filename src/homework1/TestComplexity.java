package homework1;

public class TestComplexity {

    private static int count = 0;

    private static void f() {
        count++;
    }

    public static void main(String[] args) {

        for (int i = 100; i <= 100; i++) {
            e(i);
        }
        System.out.println(count);
    }


    // 100  - 171_700
    // 1000 - 167_167_000
    static void e(int n) {
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                for (int k = 1; k <= j; k++)
                    f();
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
