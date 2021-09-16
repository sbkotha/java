package algorithm.practice;

import java.util.HashSet;

public class PrintBraces {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        HashSet<String> patterns = formMatchingBraces(4, new HashSet<String>());
        long end = System.currentTimeMillis();
        for (String each : patterns) {
            System.out.println(each);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Size = " + patterns.size());

        System.out.println("Time Taken Milli Second= " + (end-begin));
        System.out.println("Time Taken To Print Milli Second= " + (end2-end));
    }

    private static HashSet<String> formMatchingBraces(int size, HashSet<String> current) {
        if (size == 0) {
            return new HashSet<String>();
        } else if (size == 1) {
            if (current.size() == 0) {
                HashSet<String> set = new HashSet<String>();
                set.add("{}");
                return set;
            } else {
                HashSet<String> set = new HashSet<String>();
                for (String each : current) {
                    set.add(each + "{}");
                    set.add("{}" + each);
                    set.add("{" + each + "}");
                }
                return set;
            }
        } else {
            HashSet<String> set = new HashSet<String>();
            if (current.size() == 0) {
                set.add("{}");
            } else {
                for (String each : current) {
                    set.add(each + "{}");
                    set.add("{}" + each);
                    set.add("{" + each + "}");
                }
            }
            return formMatchingBraces(size - 1, set);
        }
    }

}
