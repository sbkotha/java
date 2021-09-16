package algorithm;

public class TOHCount {
    public static void main(String[] args) {
        TOHCount count = new TOHCount();
        System.out.println("Count = " + count.findMoves(25));
    }

    private long findMoves(int noPlates) {
        if (noPlates < 1) {
            return 0;
        } else if (noPlates == 1) {
            return 1;
        } else {
            return (2 * findMoves(noPlates - 1)) + 1;
        }
    }

}
