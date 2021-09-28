package algorithm.sort;

public class SelectionSort extends Sort {
    public static void main(String[] args) {
        int[] inputArray = new int[500];
        populate(inputArray);
        print("Given : ", inputArray);

        long bTime = System.currentTimeMillis();
        selectionSort(inputArray);
        long eTime = System.currentTimeMillis();

        print("Sorted : ", inputArray);

        System.out.println("Selection Sort Time: " + (eTime-bTime));
    }

    private static void selectionSort(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < inputArray.length; j ++) {
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
