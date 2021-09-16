package algorithm.dp.construct;

import java.util.ArrayList;
import java.util.Collection;

public class CanConstruct {
    static Collection<String> memo = new ArrayList<>();

    public static void main(String[] args) {
/*
        String freeText = "skateboard";
        Collection<String> dictionary = new ArrayList<>();
        dictionary.add("bo");
        dictionary.add("rd");
        dictionary.add("ate");
        dictionary.add("t");
        dictionary.add("ska");
        dictionary.add("sk");
        dictionary.add("boa");
*/
        String freeText = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        Collection<String> dictionary = new ArrayList<>();
        dictionary.add("e");
        dictionary.add("ee");
        dictionary.add("eee");
        dictionary.add("eeee");
        dictionary.add("eeeee");
        dictionary.add("eeeeee");

        boolean canCon = canConstruct(freeText, dictionary);
        System.out.println("Can Construct = " + canCon);
    }

    private static boolean canConstruct(String freeText, Collection<String> dictionary) {
        if (freeText == null || memo.contains(freeText)) {
            return false;
        }

        if (freeText.equals("")) {
            return true;
        }

        for (int i=1; i <= freeText.length(); i++) {
            String prefix = freeText.substring(0, i);
            if (dictionary.contains(prefix)) {
                String trimmedText = freeText.substring(i);
                if (canConstruct(trimmedText, dictionary)) {
                    return true;
                }
            }
        }
        memo.add(freeText);
        return false;
    }
}