package algorithm.dp.sum;

import java.util.ArrayList;
import java.util.Collection;

public class CanSum {
    static Collection<Integer> memo = new ArrayList<>();
    public static void main(String[] args) {
        int[] array = {7, 14, 16};
        int sum = 3000;
        boolean isPossible = canSum(sum, array);
        System.out.println("Is possible: " + isPossible);
    }

    private static boolean canSum(int sum, int[] array) {
        if (sum == 0) {
            return true;
        } else if (sum < 0) {
            return false;
        } else {
            if (!memo.contains(sum)) {
                for (int i = 0; i < array.length; i++) {
                    boolean can = canSum(sum - array[i], array);
                    if (can) {
                        return true;
                    }
                }
            }
        }
        memo.add(sum);
        return false;
    }
}
