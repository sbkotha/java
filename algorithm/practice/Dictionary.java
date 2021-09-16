package algorithm.practice;

import java.util.HashSet;

public class Dictionary {
    public static void main(String[] args) {
        String givenStr = "HithereWhatishappeningtoday";
        HashSet<String> dictionary = new HashSet<String>();
        dictionary.add("H");
        dictionary.add("i");
        dictionary.add("there");
        dictionary.add("is");
        dictionary.add("What");
        dictionary.add("happening");
        dictionary.add("today");

        int beginIndex = 0;
        int endIndex = 1;
        while (endIndex < givenStr.length() + 1) {
            String text = givenStr.substring(beginIndex, endIndex);
            System.out.println(text);
            if (dictionary.contains(text)) {
                dictionary.remove(text);

                beginIndex = endIndex;
                endIndex = beginIndex + 1;
            } else {
                endIndex ++;
            }
        }

        System.out.println(dictionary.size());
        if (dictionary.isEmpty()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
