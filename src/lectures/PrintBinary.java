package lectures;

import java.util.ArrayList;
import java.util.List;

public class PrintBinary {

    public static void main(String[] args) {
//        getBinary(3, "");
//        getAllCombinations(3, "");

        diceRoll(3);
    }

    public static void diceRoll(int available) {
        List<Integer> list = new ArrayList<>();
        diceHelper(available, list);
    }

    // need to add formatting
    public static void diceHelper(int available, List<Integer> soFar) {
        if (available == 0) {
            StringBuilder print = new StringBuilder("[");
            for (Integer integer : soFar) {
                print.append(integer);
                print.append(" ");
            }
            print.append("]");
            System.out.println(print);

        } else {
            for (int i = 1; i < 7; i++) {
                // choose
                soFar.add(i);
                // explore
                diceHelper(available - 1, soFar);
                // un-choose

                soFar.remove((Integer) i);
            }
            System.out.println();
        }

    }



    /**
     * Print all combinations of 0 & 1 with length n
     */
    private static void getBinary(int n, String s) {

        if (n == 0) {
            System.out.println(s);
        } else {
            getBinary(n -1, s + "0");
            getBinary(n -1, s + "1");
        }
    }

    private static void getAllCombinations(int n, String s) {
        if (n == 0) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    System.out.print(i);
                }
            }
            System.out.println();
        } else {
            getAllCombinations(n - 1, s + "0");
            getAllCombinations(n - 1, s + "1");
        }
    }

}
