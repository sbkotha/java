package algorithm.huffman;

import java.util.Comparator;

public class HuffmanNode implements Comparable<HuffmanNode> {

    private int freq;
    private char letter;

    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(char letter, int freq) {
        this.freq = freq;
        this.letter = letter;
    }

    public int getFreq() {
        return this.freq;
    }

    public char getLetter() {
        return this.letter;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanNode o1) {
        return this.freq - o1.freq;
    }
}