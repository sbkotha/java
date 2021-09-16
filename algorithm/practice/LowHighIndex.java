package algorithm.practice;

public class LowHighIndex {
    public static void main(String[] args) {
        int[] givenArray = {1, 2, 2, 2, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8};
        int element = 1;
        int leftIndex = findLeftIndex(givenArray, 0, givenArray.length - 1, element);
        int rightIndex = -1;
        if (leftIndex != -1) {
            rightIndex = findRightIndex(givenArray, leftIndex, givenArray.length - 1, element);
        }
        System.out.println("Low Index = " + leftIndex);
        System.out.println("High Index = " + rightIndex);
    }

    private static int findRightIndex(int[] givenArray, int begin, int end, int element) {
        int rightIndex = -1;
        if (begin > end) {
            // Do Nothing
        } else {
            if (begin == end) {
                if (givenArray[begin] == element) {
                    rightIndex = begin;
                    int newRight = findRightIndex(givenArray, begin + 1, givenArray.length - 1, element);
                    if (newRight != -1) {
                        rightIndex = newRight;
                    }
                }
            } else {
                int mid = (begin + end) / 2;
                if (givenArray[mid] == element) {
                    rightIndex = mid;
                    int newRight = findRightIndex(givenArray, mid + 1, givenArray.length - 1, element);
                    if (newRight != -1) {
                        rightIndex = newRight;
                    }
                } else if (element > givenArray[mid]) {
                    rightIndex = findRightIndex(givenArray, mid + 1, end, element);
                } else {
                    rightIndex = findRightIndex(givenArray, begin, mid - 1, element);
                }
            }
        }
        return rightIndex;
    }

    private static int findLeftIndex(int[] givenArray, int begin, int end, int element) {
        int leftIndex = -1;
        if (begin > end) {
            // Do Nothing
        } else {
            if (begin == end) {
                if (givenArray[begin] == element) {
                    leftIndex = begin;
                    int newLeft = findLeftIndex(givenArray, 0, begin - 1, element);
                    if (newLeft != -1) {
                        leftIndex = newLeft;
                    }
                }
            } else {
                int mid = (begin + end) / 2;
                if (givenArray[mid] == element) {
                    leftIndex = mid;
                    int newLeft = findLeftIndex(givenArray, 0, mid - 1, element);
                    if (newLeft != -1) {
                        leftIndex = newLeft;
                    }
                } else if (element < givenArray[mid]) {
                    leftIndex = findLeftIndex(givenArray, begin, mid - 1, element);
                } else {
                    leftIndex = findLeftIndex(givenArray, mid + 1, end, element);
                }
            }
        }
        return leftIndex;
    }
}
