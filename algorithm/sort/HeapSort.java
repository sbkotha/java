package algorithm.sort;

public class HeapSort extends Sort {
    public static void main(String[] args) {
        int[] inputArray = new int[25];
        populate(inputArray);
        print("Given : ", inputArray);
        long bTime = System.currentTimeMillis();
        heapSort(inputArray);
        long eTime = System.currentTimeMillis();

        print("Sorted : ", inputArray);
        System.out.println("Heap Sort Time: " + (eTime-bTime));
    }

    private static void heapSort(int[] inputArray) {
        for (int i = inputArray.length/2 - 1; i >= 0; i--) {
            maxHeapify(inputArray, inputArray.length, i);
        }
        int numberOfElements = inputArray.length;
        for (int i = 0; i < inputArray.length; i ++) {
            inputArray[numberOfElements - 1] = deleteElement(inputArray, numberOfElements);
            numberOfElements --;
        }
    }

    private static int deleteElement(int[] inputArray, int numberOfElements) {
        int deletedValue = inputArray[0];
        inputArray[0] = inputArray[numberOfElements - 1];
        maxHeapify(inputArray, numberOfElements - 1, 0);
        return deletedValue;
    }

    private static void maxHeapify(int[] inputArray, int elementCount, int i) {
        int left = i * 2 + 1;
        int right = left + 1;

        int max = inputArray[i];
        if (left < elementCount && max < inputArray[left]) {
            max = inputArray[left];
        }
        if (right < elementCount && max < inputArray[right]) {
            max = inputArray[right];
        }

        if (max != inputArray[i]) {
            if (inputArray[left] == max) {
                swapElements(inputArray, i, left);
                maxHeapify(inputArray, elementCount, left);
            } else {
                swapElements(inputArray, i, right);
                maxHeapify(inputArray, elementCount, right);
            }
        }
    }
}