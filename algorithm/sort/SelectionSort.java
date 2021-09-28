package algorithm.sort;

public class SelectionSort extends Sort {
    public static void main(String[] args) {
        int[] inputArray = new int[500];
        populate(inputArray);
        print("Given : ", inputArray);

        long bTime = System.currentTimeMillis();
        selectionSort(inputArray, 0, inputArray.length - 1);
        long eTime = System.currentTimeMillis();

        print("Sorted : ", inputArray);

        System.out.println("Selection Sort Time: " + (eTime-bTime));
    }

    private static void selectionSort(int[] inputArray, int bIndex, int eIndex) {
        for (int i = 0; i <= eIndex; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= eIndex; j ++) {
                if (inputArray[j] < inputArray[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swapElements(inputArray, i, minIndex);
            }
        }
    }

}
