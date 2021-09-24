package algorithm.practice;

import java.util.ArrayList;

public class IndexOfZero {
    public static void main(String[] args) {
        // This code assumes only one zero occurring continuously
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1}));
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {0, 1, 1, 1, 1, 1}));
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {0, 1, 1, 1, 1, 1, 0}));
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {1, 1, 1, 1, 1, 0}));
        System.out.println("Index of 0 to replace: " + findIndexOfZero(new int[] {0}));
    }

    private static int findIndexOfZero(int[] input) {
        ArrayList<GroupOf1s> groupOf1s = prepareGroupsOf1s(input);

        if (groupOf1s.size() == 2) {
            return groupOf1s.get(1).startIndex - 1;
        } else {
            int index = -1;
            int maxSum = 0;
            int i = 0;
            while (i < groupOf1s.size() - 1) {
                int sum = groupOf1s.get(i).count + groupOf1s.get(i + 1).count;
                if (sum > maxSum) {
                    maxSum = sum;
                    index = groupOf1s.get(i + 1).startIndex - 1;
                }
                i++;
            }
            return index;
        }
    }

    private static ArrayList<GroupOf1s> prepareGroupsOf1s(int[] input) {
        ArrayList<GroupOf1s> returnList = new ArrayList<>();

        // Handle middle zeros
        int count = 0;
        int startIndex = -1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                returnList.add(new GroupOf1s(startIndex, count));
                // Reset variables
                count = 0;
                startIndex = -1;
            } else {
                count ++;
                if (startIndex == -1) {
                    startIndex = i;
                }
            }
        }

        // Handle the last group as the loop is terminated
        if (count > 0) {
            returnList.add(new GroupOf1s(startIndex, count));
        } else {
            returnList.add(new GroupOf1s(input.length, 0));
        }

        return returnList;
    }
}

class GroupOf1s {
    int startIndex;
    int count;
    public GroupOf1s(int newStartIndex, int newCount) {
        this.startIndex = newStartIndex;
        this.count = newCount;
    }
}