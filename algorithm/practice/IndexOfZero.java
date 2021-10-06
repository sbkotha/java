package algorithm.practice;

public class IndexOfZero {
    public static void main(String[] args) {
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1}));
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {0, 1, 1, 1, 1, 1}));
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0}));
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {1, 1, 1, 1, 1, 0}));
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {1, 1, 1, 1, 1, 1}));
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {0}));
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0}));
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }));
    }

    private static int findIndexOfZero(int[] input) {
        int indexToReturn = -1;

        int prevIndexOfZero = -1;
        int maxSoFar = 0;

        int onesBeforeZero = 0;
        int onesAfterZero = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                if (onesBeforeZero + onesAfterZero > maxSoFar || prevIndexOfZero == -1) {
                    indexToReturn = prevIndexOfZero == -1 ? i : prevIndexOfZero;
                    maxSoFar = onesBeforeZero + onesAfterZero;
                }
                prevIndexOfZero = i;
                onesBeforeZero = onesAfterZero;
                onesAfterZero = 0;
            } else {
                onesAfterZero ++;
            }
        }

        return indexToReturn;
    }
}