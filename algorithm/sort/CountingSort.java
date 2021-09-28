package algorithm.sort;

public class CountingSort extends Sort {
    public static void main(String[] args) {
        int[] inputArray = {0, 0, 2, 1, 0, 8, 3, 4, 7, 5, 0, 4, 9, 3, 0, 1, 2, 9, 7, 3, 0};
        print("Given Array: ", inputArray);

        int maxValue = findMax(inputArray);
        int[] countArray = new int[maxValue + 1];
        populateCount(inputArray, countArray);
        aggregateCount(countArray);
        int sortedArray[] = getSortedArray(inputArray, countArray);

        print("Sorted Array: ", sortedArray);
    }

    private static int[] getSortedArray(int[] inputArray, int[] countArray) {
        int[] sortedArray = new int[inputArray.length];

        for (int i = inputArray.length - 1; i >= 0; i--) {
            sortedArray[--countArray[inputArray[i]]] = inputArray[i];
        }
        return sortedArray;
    }

    private static void aggregateCount(int[] countArray) {
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }
    }

    private static void populateCount(int[] inputArray, int[] countArray) {
        for (int i = 0; i < inputArray.length; i++) {
            countArray[inputArray[i]] ++;
        }
    }

    private static int findMax(int[] inputArray) {
        int maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }
}
