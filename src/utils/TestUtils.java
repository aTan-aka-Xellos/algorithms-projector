package utils;

public class TestUtils {


    public static void assertEquals(int a, int b) {
        if (a != b) throw new RuntimeException(a + " != " + b);
    }
}
