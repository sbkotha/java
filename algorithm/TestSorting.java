package algorithm;

public class TestSorting {

    public static void main(String args[]) {
        Sort sortObject = new Sort(true);
        int[] a1 = {2, 14, 6, 9, 10, 1};

        System.out.print("Given : ");
        sortObject.print(a1);
        long bt = System.currentTimeMillis();
        sortObject.quickSort(a1, 0, a1.length - 1);
        long et = System.currentTimeMillis();
        System.out.print("Sorted : ");
        sortObject.print(a1);

        System.out.println("Merge Sort Time: " + (et-bt));
    }

    private static void copy(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i ++) {
            a2[i] = a1[i];
        }
    }

    private static void populate(int[] a1) {
        for (int i = 0; i < a1.length; i ++) {
            a1[i] = (int) (Math.random() * 1000);
        }
    }
}