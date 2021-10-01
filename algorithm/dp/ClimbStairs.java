package algorithm.dp;

import java.util.HashMap;

public class ClimbStairs {
    private static HashMap<Integer, Long> subSolutions = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Number of ways = " + getWays(10, 3));
        System.out.println("Number of ways = " + getWays(10, 2));
    }

    private static long getWays(int n, int maxSteps) {
        subSolutions.clear();
        return countWays(n, maxSteps);
    }

    private static long countWays(int n, int maxSteps) {
        if (subSolutions.containsKey(n)) {
            return subSolutions.get(n);
        }

        if (n <= 1) {
            return 1;
        }

        long retValue = 0;
        for (int i = 1; i <= maxSteps && i <= n; i++) {
            retValue += countWays(n - i, maxSteps);
        }
        subSolutions.put(n, retValue);
        return retValue;
    }

}