package algorithm.practice;

import java.util.HashSet;
import java.util.Scanner;

public class PrintAllPalindromes {
    private static HashSet<String> palindroms = new HashSet<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String givenString = sc.nextLine();
        String givenString = "kitiki";
        for (int pivot = 0; pivot < givenString.length(); pivot++) {
            printEvenPalindromes(givenString, pivot);
            printOddPalindromes(givenString, pivot);
        }
    }

    private static void printOddPalindromes(String givenString, int pivot) {
        int lowerBound = pivot;
        int upperBound = givenString.length() - pivot - 1;

        int maxRadius;
        if (lowerBound < upperBound) {
            maxRadius = lowerBound;
        } else {
            maxRadius = upperBound;
        }

        boolean canContinue = true;
        for (int i=0; i<=maxRadius && canContinue; i++) {
            if (givenString.charAt(pivot + i) == givenString.charAt(pivot - i)) {
                String sub = givenString.substring(pivot - i, pivot + i + 1);
                if (!palindroms.contains(sub)) {
                    System.out.println(sub);
                    palindroms.add(sub);
                }
            } else {
                canContinue = false;
            }
        }
    }

    private static void printEvenPalindromes(String givenString, int pivot) {
        int lowerBound = pivot;
        int upperBound = givenString.length() - pivot - 2;

        int maxRadius;
        if (lowerBound < upperBound) {
            maxRadius = lowerBound;
        } else {
            maxRadius = upperBound;
        }

        boolean canContinue = true;
        for (int i=0; i<=maxRadius && canContinue; i++) {
            if (givenString.charAt(pivot + i + 1) == givenString.charAt(pivot - i)) {
                String sub = givenString.substring(pivot - i, pivot + i + 2);
                if (!palindroms.contains(sub)) {
                    System.out.println(sub);
                    palindroms.add(sub);
                }
            } else {
                canContinue = false;
            }
        }
    }
}