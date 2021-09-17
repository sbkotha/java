package algorithm.practice;

public class PrintBraces {
    private static int counter = 0;

    public static void main(String[] args) {
        int n = 5;
        printParenthesis("", n, 0, 0);
        System.out.println("Count = " + counter);
    }

    private static void printParenthesis(String prefix, int noOfPairs, int openCount, int closedCount) {
        if (closedCount == noOfPairs) {
            System.out.println(prefix);
            counter ++;
        } else {
            if (openCount < noOfPairs) {
                printParenthesis(prefix + "{", noOfPairs, openCount + 1, closedCount);
            }
            if (closedCount < openCount) {
                printParenthesis(prefix + "}", noOfPairs, openCount, closedCount + 1);
            }
        }
    }
}