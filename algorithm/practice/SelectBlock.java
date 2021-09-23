package algorithm.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class SelectBlock {
    public static void main(String[] args) {
        HashMap<String, Boolean> blocks[] = new HashMap[5];

        HashMap<String, Boolean> block = new HashMap<>();
        block.put("gym", false);
        block.put("school", true);
        block.put("store", false);
        blocks[0] = block;

        block = new HashMap<>();
        block.put("gym", true);
        block.put("school", false);
        block.put("store", false);
        blocks[1] = block;

        block = new HashMap<>();
        block.put("gym", true);
        block.put("school", true);
        block.put("store", false);
        blocks[2] = block;

        block = new HashMap<>();
        block.put("gym", false);
        block.put("school", true);
        block.put("store", false);
        blocks[3] = block;

        block = new HashMap<>();
        block.put("gym", false);
        block.put("school", true);
        block.put("store", true);
        blocks[4] = block;

        // Generate base score for each block
        HashMap<String, Integer> scores[] = new HashMap[blocks.length];
        for (int i=0; i < blocks.length; i++) {
            HashMap<String, Integer> score = new HashMap<>();
            score.put("gym", getScore(blocks, i, "gym"));
            score.put("school", getScore(blocks, i, "school"));
            score.put("store", getScore(blocks, i, "store"));
            scores[i] = score;
        }

        Collection<String> requirements = new ArrayList<>();
        requirements.add("gym");
        requirements.add("school");
        requirements.add("store");

        int minScore = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i=0; i < blocks.length; i++) {
            int score = -1;
            for (String requirement : requirements) {
                if (score < scores[i].get(requirement)) {
                    score = scores[i].get(requirement);
                }
            }
            if (score < minScore) {
                minIndex = i;
                minScore = score;
            }
        }
        System.out.println("Suitable Building = " + minIndex);
    }

    private static Integer getScore(HashMap<String, Boolean>[] blocks, int blockIndex, String facility) {
        if (blocks[blockIndex].get(facility) == true) {
            return 0;
        }
        boolean canContinue = true;
        for (int i = blockIndex - 1, j = blockIndex + 1; canContinue; i--, j++) {
            if (i >= 0 && blocks[i].get(facility)) {
                return blockIndex - i;
            }
            if (j < blocks.length && blocks[j].get(facility)) {
                return j - blockIndex;
            }
            if (i < 0 && j >= blocks.length) {
                canContinue = false;
            }
        }
        return Integer.MAX_VALUE;
    }
}