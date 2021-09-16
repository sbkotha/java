package algorithm.dp;

import java.util.HashMap;

public class GridTraveller {
    static HashMap<String, Long> memo = new HashMap<>();
    public static void main(String[] args) {
        int rows = 8;
        int cols = 4;

        long count = getCount(rows, cols);
        System.out.println("Count = " + count);
    }

    private static long getCount(int rows, int cols) {
        if (rows == 0 || cols == 0) {
            return 0;
        } else if (rows == 1 && cols == 1) {
            return 1;
        } else {
            String key1 = rows + ":" + cols;
            String key2 = cols + ":" + rows;
            if (memo.containsKey(key1) || memo.containsKey(key2)) {
                return memo.get(key1) == null ? memo.get(key2) : memo.get(key1);
            } else {
                long count = getCount(rows - 1, cols) + getCount(rows, cols - 1);
                memo.put(rows + ":" + cols, count);
                return count;
            }
        }
    }
}
