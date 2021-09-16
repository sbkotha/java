package algorithm.dp.sum;

import java.util.ArrayList;
import java.util.Collection;

public class HowSum {
    static Collection<Integer> memo = new ArrayList<>();
    public static void main(String[] args) {
        int sum = 301;
        int[] array = {10, 11, 14};
        Collection<Integer> solution = howSum(sum, array);
        if (solution != null) {
            System.out.print("Solution = ");
            for (int i : solution) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println("No Solution");
        }
    }

    private static Collection<Integer> howSum(int sum, int[] array) {
        if (sum == 0) {
            return new ArrayList<>();
        } else if (sum < 0) {
            return null;
        } else {
            if (!memo.contains(sum)) {
                for (int i = 0; i < array.length; i++) {
                    Collection<Integer> solution = howSum(sum - array[i], array);
                    if (solution != null) {
                        solution.add(array[i]);
                        return solution;
                    }
                }
            }
        }
        memo.add(sum);
        return null;
    }
}
