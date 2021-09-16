package algorithm.practice;

import algorithm.Tree;

public class CompareTrees {
    public static void main(String[] args) {
        Tree t1a = new Tree(40);

        Tree n1a = new Tree(20);
        t1a.setLeftNode(n1a);
        Tree n2a = new Tree(50);
        t1a.setRightNode(n2a);
        n2a.setRightNode(new Tree(10));

        Tree t1b = new Tree(40);

        Tree n1b = new Tree(20);
        t1b.setLeftNode(n1b);
        Tree n2b = new Tree(50);
        t1b.setRightNode(n2b);
        n2b.setRightNode(new Tree(10));

        if (compareTrees(t1a, t1b)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean compareTrees(Tree t1, Tree t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else {
            if (t1.getNodeValue() == t2.getNodeValue()) {
                if ((t1.getLeftNode() != null && t2.getLeftNode() == null) || (t1.getLeftNode() == null && t2.getLeftNode() != null)) {
                    return false;
                } else {
                    return compareTrees(t1.getLeftNode(), t2.getLeftNode()) && compareTrees(t1.getRightNode(), t2.getRightNode());
                }
            } else {
                return false;
            }
        }
    }

}
