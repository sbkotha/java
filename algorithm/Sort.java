package algorithm;

public class Sort {
    boolean print = false;

    public Sort(boolean print) {
        this.print = print;
    }

    public void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public void mergeSort(int[] array, int begin, int end) {
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
            if (this.print) {
                print(array);
            }
        }
    }

    private void merge(int[] a, int begin, int mid, int end) {
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

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                if (this.print) {
                    print(array);
                }
            }
        }
    }

    public void quickSort(int[] array, int low, int high) {
        if (low == high || low > high) {
            // DO nothing
        } else if (high - low == 1) {
            if (array[low] > array[high]) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        } else {
            int pivot = findPivot(array, low, high);
            System.out.println(pivot);
            print(array);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private int findPivot(int[] array, int low, int high) {
        int pivotValue = array[low];
        int i = low + 1;
        int j = high;

        do {

            do {
                i ++;
            } while (i < high && pivotValue > array[i]);
            if (pivotValue <= array[i-1]) {
                i--;
            }

            do {
                j--;
            } while (low > j && pivotValue <= array[j]);
            if (pivotValue > array[j+1]) {
                j++;
            }

            if (i < j) {
                swapElements(array, i, j);
            }
        } while(i < j);
        swapElements(array, low, i);
        return i;
    }

    private void swapElements(int[] array, int beginIndex, int endIndex) {
        int temp = array[beginIndex];
        array[beginIndex] = array[endIndex];
        array[endIndex] = temp;
    }

}