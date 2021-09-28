package algorithm.sort;

public class QuickSort extends Sort {
    public static void main(String args[]) {
        int[] inputArray = new int[500];
        populate(inputArray);
        print("Given : ", inputArray);

        long bTime = System.currentTimeMillis();
        quickSort(inputArray, 0, inputArray.length - 1);
        long eTime = System.currentTimeMillis();

        print("Sorted : ", inputArray);

        System.out.println("Quick Sort Time: " + (eTime-bTime));
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = findPivot(array, low, high);
        quickSort(array, low, pivot - 1);
        quickSort(array, pivot + 1, high);
    }

    private static int findPivot(int[] array, int low, int high) {
        int pivotValue = array[high];
        int pIndex = low;
        for (int i = low; i <= high; i++) {
            if (array[i] < pivotValue) {
                swapElements(array, i, pIndex);
                pIndex ++;
            }
        }
        swapElements(array, high, pIndex);
        return pIndex;
    }
}