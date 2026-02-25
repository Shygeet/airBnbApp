package exception;

import java.util.Arrays;

public class ViewDay2P4GroupWithSum {

    public static void main(String[] args) {

        int a[] = {0, 1, 47, 3, 5, 4, 77, 9};
        int target = 12;

        System.out.println("All groups with sum " + target + ":");

        for (int i = 0; i < a.length; i++) {
            int sum = 0;

            for (int j = i; j < a.length; j++) {
                sum += a[j];

                if (sum == target) {
                    // print subarray from i to j
                    System.out.println(Arrays.toString(Arrays.copyOfRange(a, i, j + 1)));
                }

                if (sum > target) {
                    break; // optimization (works for positive numbers)
                }
            }
        }
    }
}
