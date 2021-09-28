package algorithm.sort;

public class BubbleSort extends Sort {
    public static void main(String[] args) {
        int[] inputArray = new int[500];
        populate(inputArray);
        print("Given : ", inputArray);

        long bTime = System.currentTimeMillis();
        bubbleSort(inputArray);
        long eTime = System.currentTimeMillis();

        print("Sorted : ", inputArray);

        System.out.println("Bubble Sort Time: " + (eTime-bTime));

    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
