package algorithm.practice;

import java.util.HashSet;

public class PrintBraces1 {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        HashSet<String> patterns = formMatchingBraces(5);
        long end = System.currentTimeMillis();
        for (String each : patterns) {
            System.out.println(each);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Size = " + patterns.size());

        System.out.println("Time Taken Milli Second= " + (end-begin));
        System.out.println("Time Taken To Print Milli Second= " + (end2-end));
    }

    private static HashSet<String> formMatchingBraces(int size) {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            HashSet<String> smallSolution = new HashSet<>();
            smallSolution.add("{}");
            return smallSolution;
        }
        HashSet<String> fullSolution = new HashSet<>();

        HashSet<String> subSolution = formMatchingBraces(size - 1);
        for (String each : subSolution) {
            fullSolution.add("{" + each + "}");
            fullSolution.add("{}" + each);
            fullSolution.add(each + "{}");
        }
        return fullSolution;
    }

}
