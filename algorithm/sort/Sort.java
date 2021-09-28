package algorithm.sort;

public abstract class Sort {
    public static void print(String prefix, int[] a) {
        System.out.print(prefix);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void populate(int[] array) {
        for (int i = 0; i < array.length; i ++) {
            array[i] = (int) (Math.random() * 1000);
        }
    }
}