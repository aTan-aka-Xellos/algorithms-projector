package homework1;

public class Cube {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            int cube = i * i * i;
            System.out.println(cube(cube));
        }


    }



    private static double cube(int n) {

        double bad = 0, good = n;
        double m = (bad + good) / 2;

        while (bad != m && good != m) {
            if (m * m * m >= n) {
                good = m;
            } else {
                bad = m;
            }
            m = (good + bad) / 2;
        }
        return good;
    }
}
