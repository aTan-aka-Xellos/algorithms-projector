package homework1;

import static utils.TestUtils.assertEquals;

public class SherlockAndSquares {


    public static void main(String[] args) {

        assertEquals(squares(1, 1), 1);
        assertEquals(squares(1, 2), 1);
        assertEquals(squares(1, 4), 2);
        assertEquals(squares(1, 9), 3);
        assertEquals(squares(1, 10), 3);

        assertEquals(squares(3, 9), 2);
        assertEquals(squares(3, 10), 2);
        assertEquals(squares(17, 24), 0);

        assertEquals(squares(4, 4), 1);
        assertEquals(squares(1, 100), 10);
        assertEquals(squares(1, 100), 10);
        assertEquals(squares(1, 101), 10);
    }

    static int squares(int a, int b) {

        double sqrtA = Math.sqrt(a);
        int minSqrt = (int) (sqrtA % 1 == 0 ? sqrtA : ++sqrtA);
        int maxSqrt = (int) Math.sqrt(b) + 1;
        return maxSqrt - minSqrt;
    }

}
