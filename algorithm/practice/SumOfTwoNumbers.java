package algorithm.practice;

import java.util.HashSet;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] array = {3, 5, 9, 0, 2, -4};

        int sum = -2;

        HashSet<Integer> set = new HashSet<Integer>();

        boolean found = false;
        for (int i=0; i<array.length && !found; i++) {
            if (set.contains(array[i])) {
                found = true;
            } else {
                set.add(sum - array[i]);
            }
        }
        System.out.println(found ? "Yes" : "No");
    }
}
