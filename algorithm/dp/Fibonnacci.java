package algorithm.dp;

import java.util.HashMap;

public class Fibonnacci {
    static HashMap<Integer, Long> known = new HashMap<>();
    public static void main(String[] args) {
        int number = 50;
        for (int i = 1; i <= number; i++) {
            long fibo = findFibo(i);
            System.out.println(i + "th Fibonnacci = " + fibo);
        }
    }

    private static long findFibo(int number) {
        if (number == 0) {
            known.put(number, 0L);
            return 0;
        } else if (number == 1) {
            known.put(number, 1L);
            return 1;
        } else {
            if (known.containsKey(number)) {
                return known.get(number);
            } else {
                long prev = findFibo(number - 1);
                long prevPrev = findFibo(number - 2);
                known.put(number, prev + prevPrev);
                return  prev + prevPrev;
            }
        }
    }
}
