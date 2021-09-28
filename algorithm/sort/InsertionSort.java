package algorithm.sort;

public class InsertionSort extends Sort {
    public static void main(String[] args) {
        int[] inputArray = new int[500];
        populate(inputArray);
        print("Given : ", inputArray);

        long bTime = System.currentTimeMillis();
        insertionSort(inputArray);
        long eTime = System.currentTimeMillis();

        print("Sorted : ", inputArray);

        System.out.println("Insertion Sort Time: " + (eTime-bTime));

    }

    private static void insertionSort(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            int temp = inputArray[i];
            int j = i - 1;
            while (j >= 0 && inputArray[j] > temp) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = temp;
        }
    }

}
