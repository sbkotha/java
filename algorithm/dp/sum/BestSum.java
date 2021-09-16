package algorithm.dp.sum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class BestSum {
    static Collection<Integer> memoNoSolution = new ArrayList<>();
    static HashMap<Integer, Collection<Integer>> memoBestSolution = new HashMap<>();
    public static void main(String[] args) {
        int sum = 1001;
        int[] array = {1, 2, 5, 25};
        Collection<Integer> solution = bestSum(sum, array);
        if (solution != null) {
            System.out.print("Solution = ");
            for (int i : solution) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println("No Solution");
        }
    }

    private static Collection<Integer> bestSum(int sum, int[] array) {
        if (memoNoSolution.contains(sum)) {
            return null;
        }

        if (memoBestSolution.containsKey(sum)) {
            return memoBestSolution.get(sum);
        }

        if (sum == 0) {
            return new ArrayList<>();
        } else if (sum < 0) {
            return null;
        } else {
            Collection<Integer> bestSolution = null;
            for (int i = 0; i < array.length; i++) {
                Collection<Integer> newSolution = bestSum(sum - array[i], array);

                if (newSolution != null) {
                    Collection<Integer> solutionCopy = new ArrayList<>();
                    solutionCopy.addAll(newSolution);
                    solutionCopy.add(array[i]);

                    if (bestSolution == null || solutionCopy.size() < bestSolution.size()) {
                        bestSolution = solutionCopy;
                    }
                }
            }
            if (bestSolution != null) {
                Collection<Integer> copy = new ArrayList<>();
                copy.addAll(bestSolution);

                memoBestSolution.put(sum, copy);
                return bestSolution;
            }
        }
        memoNoSolution.add(sum);
        return null;
    }
}