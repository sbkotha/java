package algorithm.practice;

public class PrintBraces2 {
    private static int counter = 0;

    public static void main(String[] args) {
        int n = 3;
        char[] str = new char[2 * n];
        printParenthesis(str, 0, n, 0, 0);
        System.out.println("Count = " + counter);
    }

    static void printParenthesis(char str[], int pos, int n, int open, int close) {
        if (close == n) {
            // print the combinations
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
            counter++;
        } else {
            if (open < n) {
                str[pos] = '{';
                printParenthesis(str, pos + 1, n, open + 1, close);
            }
            if (open > close) {
                str[pos] = '}';
                printParenthesis(str, pos + 1, n, open, close + 1);
            }
        }
    }
}