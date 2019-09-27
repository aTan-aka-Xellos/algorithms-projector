package homework1;

import static java.util.Arrays.asList;

import java.util.List;

public class SherlockAndArray {

    public static void main(String[] args) {

        System.out.println(balancedSums(asList(1, 2, 3)));
        System.out.println(balancedSums(asList(1, 2, 3, 3)));
        System.out.println();
        System.out.println(balancedSums(asList(1, 1, 4, 1, 1)));
        System.out.println(balancedSums(asList(2 ,0, 0 ,0)));
        System.out.println(balancedSums(asList(0, 0, 2, 0)));
        System.out.println();
        System.out.println(balancedSums(asList(1)));
        System.out.println(balancedSums(asList(1, 1)));
        System.out.println(balancedSums(asList(0, 1)));
        System.out.println();
        System.out.println(balancedSums(asList(0)));
        System.out.println(balancedSums(asList(0, 0)));
        System.out.println(balancedSums(asList(0, 0, 1)));
        System.out.println(balancedSums(asList(1, 0, 0)));

        System.out.println();
        System.out.println(balancedSums(asList(1, 2, 3, 4, 0, 10)));
        System.out.println(balancedSums(asList(0, 0)));

    }

    // Time complexity: O(2N)
    static String balancedSums(List<Integer> arr) {

        long leftSum = 0, rightSum = 0;
        int index = 0;

        for (int i = 1; i < arr.size(); i++) {
            rightSum += arr.get(i);
        }

        while (leftSum != rightSum && index < arr.size() - 1) {
            leftSum += arr.get(index++);
            rightSum -= arr.get(index);
        }
        return leftSum == rightSum ? "YES" : "NO";
    }


}
