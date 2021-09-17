package algorithm.practice;

public class PrintBraces {
    private static int counter = 0;

    public static void main(String[] args) {
        printAllCombinations(1);
        printAllCombinations(2);
        printAllCombinations(3);
        printAllCombinations(4);
    }

    private static void printAllCombinations(int n) {
        System.out.println("N = " + n);
        printBraces("", n, 0, 0);
        System.out.println("Count = " + counter);
        System.out.println("-----------");
    }

    private static void printBraces(String prefix, int noOfPairs, int openCount, int closedCount) {
        if (closedCount == noOfPairs) {
            System.out.println(prefix);
            counter ++;
        } else {
            if (openCount < noOfPairs) {
                printBraces(prefix + "{", noOfPairs, openCount + 1, closedCount);
            }
            if (closedCount < openCount) {
                printBraces(prefix + "}", noOfPairs, openCount, closedCount + 1);
            }
        }
    }
}