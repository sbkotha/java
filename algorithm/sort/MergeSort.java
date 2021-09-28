package algorithm.sort;

public class MergeSort extends Sort {
    public static void main(String[] args) {
        int[] inputArray = new int[500];
        populate(inputArray);
        print("Given : ", inputArray);

        long bTime = System.currentTimeMillis();
        mergeSort(inputArray, 0, inputArray.length - 1);
        long eTime = System.currentTimeMillis();

        print("Sorted : ", inputArray);

        System.out.println("Merge Sort Time: " + (eTime-bTime));

    }

    public static void mergeSort(int[] array, int begin, int end) {
        if (end == begin) {
            //do nothing
        } else if (end - begin == 1) {
            if (array[begin] > array[end]) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        } else {
            int mid = (begin + end) / 2;
            mergeSort(array, begin, mid);
            mergeSort(array, mid + 1, end);
            merge(array, begin, mid, end);
        }
    }

    private static void merge(int[] a, int begin, int mid, int end) {
        int[] a1 = new int[mid - begin + 1];
        int[] a2 = new int[end - mid];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = a[begin + i];
        }
        for (int i = 0; i < a2.length; i++) {
            a2[i] = a[mid + 1 + i];
        }
        int i = begin, i1 = 0, i2 = 0;
        do {
            if (a1[i1] < a2[i2]) {
                a[i] = a1[i1];
                i1++;
            } else {
                a[i] = a2[i2];
                i2++;
            }
            i++;
        } while(i1 < a1.length && i2 < a2.length);

        if (i1 < a1.length) {
            do {
                a[i] = a1[i1];
                i1++;
                i++;
            } while(i1 < a1.length);
        } else if (i2 < a2.length) {
            do {
                a[i] = a2[i2];
                i2++;
                i++;
            } while(i2 < a2.length);
        }
    }
}
