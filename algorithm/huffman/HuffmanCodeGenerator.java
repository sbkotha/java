package algorithm.huffman;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCodeGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        System.out.println("Input Text:" + text);

        // Prepare a Freq Table
        HashMap<Character, Integer> freqTable = new HashMap<Character, Integer>();
        for (int i=0; i<text.length(); i++) {
            Character oneChar = text.charAt(i);
            if (freqTable.containsKey(oneChar)) {
                freqTable.put(oneChar, freqTable.get(oneChar).intValue() + 1);
            } else {
                freqTable.put(oneChar, new Integer(1));
            }
        }

        // Prepare a Priority Que using freq table
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<HuffmanNode>();
        for (Character eachChar : freqTable.keySet()) {
            Integer freq = freqTable.get(eachChar);
            HuffmanNode node = new HuffmanNode(new Character(eachChar.charValue()), new Integer(freq.intValue()));
            priorityQueue.add(node);
        }

        // Do optimal merge and prepare a tree now using the Q
        while (priorityQueue.size() > 1) {
            HuffmanNode node1 = priorityQueue.poll();
            HuffmanNode node2 = priorityQueue.poll();
            HuffmanNode mergedNode = new HuffmanNode('-', node1.getFreq() + node2.getFreq());
            mergedNode.setLeft(node1);
            mergedNode.setRight(node2);
            priorityQueue.add(mergedNode);
        }

        HuffmanNode root = priorityQueue.peek();
        //Now print the Huffman code for the given String
        StringBuffer encodedText = new StringBuffer();
        for (int i=0; i<text.length(); i++) {
            char oneChar = text.charAt(i);
            String code = traverseTreeAndGetCode(root, oneChar, "");
            encodedText.append(code);
            System.out.println(oneChar + "-->" + code);
        }
        System.out.println("Final Text: " + encodedText.toString());
        System.out.println("Size Before Encode: " + (text.length() * 8));
        System.out.println("Size After Encode: " + encodedText.toString().length());
    }

    private static String traverseTreeAndGetCode(HuffmanNode treeRoot, char oneChar, String s) {
        if (treeRoot.getRight() == null && treeRoot.getLeft() == null) {
            if (treeRoot.getLetter() == oneChar) {
                return s;
            }
        } else {
            String left = traverseTreeAndGetCode(treeRoot.getLeft(), oneChar, s + "0");
            if (left.length() > 0) {
                return left;
            }
            String right = traverseTreeAndGetCode(treeRoot.getRight(), oneChar, s + "1");
            if (right.length() > 0) {
                return right;
            }
        }
        return "";
    }
}