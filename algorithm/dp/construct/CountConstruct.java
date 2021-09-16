package algorithm.dp.construct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CountConstruct {
    static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        /*
        String freeText = "skateboard";
        Collection<String> wordBank = new ArrayList<>();
        wordBank.add("bo");
        wordBank.add("rd");
        wordBank.add("ate");
        wordBank.add("t");
        wordBank.add("ska");
        wordBank.add("sk");
        wordBank.add("boa");
        */

        String freeText = "enterapotentpot";
        Collection<String> wordBank = new ArrayList<>();
        wordBank.add("a");
        wordBank.add("p");
        wordBank.add("en");
        wordBank.add("ent");
        wordBank.add("te");
        wordBank.add("ente");
        wordBank.add("r");
        wordBank.add("enter");
        wordBank.add("ot");
        wordBank.add("o");
        wordBank.add("t");

        int count = countConstruct(freeText, wordBank);
        System.out.println("Count Construct = " + count);
    }

    private static int countConstruct(String freeText, Collection<String> dictionary) {
        if (memo.containsKey(freeText)) {
            return memo.get(freeText);
        }

        if (freeText.equals("")) {
            return 1;
        }

        int totalCount = 0;
        for (int i=1; i <= freeText.length(); i++) {
            String prefix = freeText.substring(0, i);
            if (dictionary.contains(prefix)) {
                String trimmedText = freeText.substring(i);
                int count = countConstruct(trimmedText, dictionary);
                totalCount += count;
            }
        }
        memo.put(freeText, totalCount);
        return totalCount;
    }
}