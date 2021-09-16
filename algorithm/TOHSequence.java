package algorithm;

public class TOHSequence {
    public static void main(String[] args) {
        TOHSequence seq = new TOHSequence();
        seq.printMoves(10, 'A', 'B', 'C');
    }

    private void printMoves(int noPlates, char from, char temp, char to) {
        if (noPlates < 1) {
            return; // Do nothing
        } else if (noPlates == 1) {
            System.out.println(from + " --> " + to);
        } else {
            printMoves(noPlates - 1, from, to, temp);
            System.out.println(from + " --> " + to);
            printMoves(noPlates - 1, temp, from, to);
        }
    }
}