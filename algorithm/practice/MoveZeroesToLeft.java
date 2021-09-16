package algorithm.practice;

public class MoveZeroesToLeft {
    public static void main(String[] args) {
        int array[] = {30, 5, 0, 9, 0, 34, 0, 8, 0};
        int readIndex = array.length - 1;
        int writeIndex = array.length - 1;

        while (readIndex >= 0) {
            if (array[readIndex] > 0) {
                array[writeIndex] = array[readIndex];
                writeIndex --;
            }
            readIndex --;
        }
        while (writeIndex >= 0) {
            array[writeIndex] = 0;
            writeIndex --;
        }
        for (int each:array) {
            System.out.print(each + " ");
        }
    }
}
