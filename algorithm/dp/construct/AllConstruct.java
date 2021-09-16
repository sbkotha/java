package algorithm.dp.construct;

import java.util.ArrayList;
import java.util.Collection;

public class AllConstruct {
    public static void main(String[] args) {
        String freeText = "abcdef";
        Collection<String> wordBank = new ArrayList<>();
        wordBank.add("ab");
        wordBank.add("abc");
        wordBank.add("cd");
        wordBank.add("def");
        wordBank.add("abcd");
        wordBank.add("ef");
        wordBank.add("c");

        Collection<Collection<String>> allCombinations = allConstruct(freeText, wordBank);
        for (Collection<String> oneCombination : allCombinations) {
            System.out.print("[ ");
            for (String word : oneCombination) {
                System.out.print("'" + word + "' ");
            }
            System.out.println("]");
        }
    }

    private static Collection<Collection<String>> allConstruct(String freeText, Collection<String> wordBank) {
        if (freeText.equals("")) {
            return new ArrayList<>();
        }

        Collection<Collection<String>> allCombinations = null;
        for (int i=1; i <= freeText.length(); i++) {
            String prefix = freeText.substring(0, i);
            if (wordBank.contains(prefix)) {
                String trimmedText = freeText.substring(i);
                Collection<Collection<String>> trimmedTextCombinations = allConstruct(trimmedText, wordBank);
                if (trimmedTextCombinations != null) {
                    if (allCombinations == null) {
                        allCombinations = new ArrayList<>();
                    }
                    if (trimmedTextCombinations.isEmpty()) {
                        Collection<String> solution = new ArrayList<>();
                        solution.add(prefix);
                        allCombinations.add(solution);
                    } else {
                        for (Collection<String> eachSubSolution : trimmedTextCombinations) {
                            Collection<String> eachFullSolution = new ArrayList<>();
                            eachFullSolution.add(prefix);
                            eachFullSolution.addAll(eachSubSolution);
                            allCombinations.add(eachFullSolution);
                        }
                    }
                }
            }
        }

        return allCombinations;
    }
}
