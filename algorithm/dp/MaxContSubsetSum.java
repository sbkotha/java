package algorithm.dp;

public class MaxContSubsetSum {
    public static void main(String[] args) {
        int[] inputArray = {2, 1, -7, 4, -1, 0, 3, 5, 10, -2, 1, 2, -5, 6};
        bruteForceSolution(inputArray);
        optimisedSolution(inputArray);
    }

    private static void optimisedSolution(int[] inputArray) {
        int maxSum = 0;
        int bestSumSoFar = 0;

        int maxBeginIndex = 0;
        int maxEndIndex = 0;
        int beginIndex = 0;

        for (int i = 0; i < inputArray.length; i++) {
            bestSumSoFar += inputArray[i];

            if (bestSumSoFar < inputArray[i]) {
                bestSumSoFar = inputArray[i];
                beginIndex = i;
            }

            if (bestSumSoFar > maxSum) {
                maxSum = bestSumSoFar;
                maxBeginIndex = beginIndex;
                maxEndIndex = i;
            }
        }
        System.out.print("Optimised Max Sum : [");

        for (int i = maxBeginIndex; i < maxEndIndex; i++) {
            System.out.print(inputArray[i] + " + ");
        }
        System.out.println(inputArray[maxEndIndex] + "] = " + maxSum);

    }

    private static void bruteForceSolution(int[] inputArray) {
        int maxSum = 0;
        int maxStart = 0;
        int maxEnd = 0;

        for (int i = 0; i < inputArray.length; i++) {
            int sum = 0;
            for (int j = i; j < inputArray.length; j++) {
                sum += inputArray[j];
                if (sum > maxSum) {
                    maxStart = i;
                    maxEnd = j;
                    maxSum = sum;
                }
            }
        }
        System.out.print("Bruteforce Max Sum : [");
        for (int i = maxStart; i < maxEnd; i++) {
            System.out.print(inputArray[i] + " + ");
        }
        System.out.println(inputArray[maxEnd] + "] = " + maxSum);
    }
}
